### Copy the keypairs to jenkins home directory 

jenkins home = /var/lib/jenkins 

```bash 
sudo mkdir -p /var/lib/jenkins/.ssh
sudo su - jenkins
pwd

# copy both private and public keys 
sudo cp /home/kk/.ssh/id_ed25519 /var/lib/jenkins/.ssh/
sudo cp /home/kk/.ssh/id_ed25519.pub /var/lib/jenkins/.ssh/


# permission and mod
sudo chown -R jenkins:jenkins /var/lib/jenkins/.ssh
sudo chmod 700 /var/lib/jenkins/.ssh
sudo chmod 600 /var/lib/jenkins/.ssh/id_ed25519
sudo chmod 644 /var/lib/jenkins/.ssh/id_ed25519.pub
```