# Ubuntu on Windows installation guide
## 1. Download an Ubuntu image
You can download an Ubuntu image [here](https://ubuntu.com/download/desktop).
![Ubuntu download page screenshot](chrome_ncSeJqhVoC.png)

## 2. Download and install VirtualBox
You can download VirtualBox from the downloads page [here](https://www.virtualbox.org/wiki/Downloads).
![alt text](../image.png)

Once you have completed the installation, go ahead and run VirtualBox.
![alt text](../image-1.png)

## 3. Create a new virtual machine
Click **New** to create a new virtual machine. Fill in the appropriate details.
![alt text](../image-3.png)

## 4. Create a user profile
![alt text](../image-4.png)

## 5. Define the Virtual Machine’s resources
In the next section we can specifiy how much of our host machine’s memory and processors the virtual machine can use. For good performance it’s recommended to provide your VM with around 8GB of RAM (althought 4GB will still be usable) and 4 CPUs. Try to remain in the green areas of each slider to prevent issues with your machine running both the VM and the host OS.
![alt text](../image-5.png)

Then we need to specify the size of the hard disc for the virtual machine. For Ubuntu we recommend around 25 GB as a minimum. By default the hard disk will scale dynamically as more memory is required up to the defined limit. If you want to pre-allocate the full amount, check the ‘Pre-allocate Full Size’ check box. This will improve performance but may take up unnecessary space.
![alt text](../image-7.png)

Click **Next** to continue and view a summary of your machine setting.
![alt text](../image-8.png)
After this click **Finish** to initialize the machine!

## 6. Install your image
Click **Start** to launch the virtual machine.
![alt text](../image-9.png)
![alt text](../image-10.png)

### Congratulations!