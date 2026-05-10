


https://api.telegram.org/bot<token>/getUpdates


- Send message to telegram 
```bash 



def token="your-bot-token"
def chatId="your-chat-id"
sh """
    curl -s -X POST "https://api.telegram.org/bot${token}/sendMessage" -d chat_id="${chatId}" -d text="Hello from Jenkin"

"""
```