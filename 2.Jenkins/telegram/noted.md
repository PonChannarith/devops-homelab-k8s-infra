


https://api.telegram.org/bot<token>/getUpdates


- Send message to telegram 
```bash 



def token="8543591574:AAF4VT6yXHMfZ4QrdynsPPv6lwYMpzIKtXA"
def chatId="683081514"
sh """
    curl -s -X POST "https://api.telegram.org/bot${token}/sendMessage" -d chat_id="${chatId}" -d text="Hello from Jenkin"

"""
```