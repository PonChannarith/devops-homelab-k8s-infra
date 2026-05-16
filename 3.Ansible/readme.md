## INSTALLING ANSIBLE ON UBUNTU
```bash 
# 1. Install ansible 

sudo apt update
sudo apt install software-properties-common
sudo add-apt-repository --yes --update ppa:ansible/ansible
sudo apt install ansible
```
- Inventory 
ex. `inventory.yaml`, `inventory.ini` : file that contains the information about the machines that ansible can manage

```bash 

# To verify if ansible controller can controll machines inside the inventory file 
# you must be inside the folder that contains the inventory.ini file 

# -m = module ( actions ex copy, create file , chmod )
ansible -i inventory.ini instance1 -m ping 
ansible -i inventory.ini instance2 -m ping 
ansible -i inventory.ini all -m ping 

```