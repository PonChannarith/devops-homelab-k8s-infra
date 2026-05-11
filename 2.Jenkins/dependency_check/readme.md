- Delete the cache of the dependencies cache 
```bash
sudo find /var/lib/jenkins -type d -name "*dependency-check*" -exec rm -rf {} +


sudo systemctl restart jenkins

# clean the database
sudo rm -rf /var/lib/jenkins/.dependency-check
sudo rm -rf /var/lib/jenkins/odc-data
sudo mkdir -p /var/lib/jenkins/odc-data
sudo chown -R jenkins:jenkins /var/lib/jenkins/odc-data
sudo systemctl restart jenkins
```