## NOTE FOR KUBERNETES 

- When working with kubespray, you will need to install the 
`requirements.txt` 
- the better way to install it is by using the python virtual env 
```bash 
sudo apt update
sudo apt install python3-venv

# to created the virtual env 
python3 -m venv venv 
source venv/bin/activate 


# install the required package s
pip -r requirements.txt 

# To start the ha cluster setup 
ansible-playbook -i inventory/sample/inventory.ini \
    cluster.yml -b 

# if you have error, or want to setup all over again 
ansible-playbook -i inventory/sample/inventory.ini \
    reset.yml -b
```
