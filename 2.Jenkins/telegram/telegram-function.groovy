pipeline {
    agent any

    stages {
        stage('Send Telegram') {
            steps {
                script{
                    // You need to replace the value here 
                    def token="BotTOken"
                    def chatId="ChatID"
                    def message1="""
                    hello world 
                    welcome to jenkins telegram message
                    """

                    def message2="""
                    *Hello World* 
                    Testing markdown 
                    """
                    sendTelegramMessage("${message1}","${token}","${chatId}")
                    sendTelegramMessageV1("${message2}","${token}","${chatId}")
                }
                
                
            }
        }
    }
}


def sendTelegramMessageV1(String message, String token , String chatId){
    sh """
    curl -s -X POST "https://api.telegram.org/bot${token}/sendMessage" -d chat_id="${chatId}" -d parse_mode="Markdown"  -d text="${message}"

    """
}
def sendTelegramMessage(String message, String token , String chatId) {
    // uppgrade to use Markdown version instead 
    def encodedMessage = URLEncoder.encode(message, "UTF-8")
    sh """
        curl -s -X POST https://api.telegram.org/bot${token}/sendMessage \\
        -d chat_id=${chatId} \\
        -d text="${encodedMessage}" > /dev/null
    """
}