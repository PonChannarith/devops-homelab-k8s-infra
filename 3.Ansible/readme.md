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

- If you want to specific the location of your private key file 
```bash 
[all:vars]
ansible_user=ubuntu
ansible_ssh_private_key_file=~/.ssh/id_rsa
```

### 1. Using Adhoc command with ansible 
```bash 
# Install nginx on all machine 
ansible -i inventory.ini all -m apt -a "name=nginx state=present" 

ansible -i inventory.ini all -m command -a "date" 

# To uninstall the nginx on all the machine 
ansible -i inventory.ini all -m apt -a "name=nginx state=absent" 
```


# Date 17-May-2026 
CaC = Configuration as Code 
IaC = Infrastructure as Code 


Write the code in order to install service , configure services using yaml ( ansible )

What we have studied so far. 
- How to install ansible 
    - local machine 
    - gcp instance 

- Ansible can controll other machines, but it's agentless 

- Inventory 
    - folder or files that contains the information about the machhines that ansible controller will manage 
    - ex. 
        - prod/host.ini 
        - dev/host.ini 
    - Inventory file can be written using either `.ini` or `yaml` extension 

- **Module** : a specific tasks 
    ex. run command , copy file , create folder, create file 
```bash 
ansible -i inventory.ini groupA -m command -a "uptime" 
```
- Ad-hoc:  
```bash
ansible -i inventory.ini groupA -m command -a "uptime" 

```
- Ansible Playbooks 
    - a yaml file that contains series `tasks` and `role` for performing a specific series of actions 
    - ex. We have three machines , we want to install nginx on those machine 


```bash 
# docker compose v2 already installed , if you don't have it on your machine just use this command 

 
ansible-galaxy collection install community.docker


```