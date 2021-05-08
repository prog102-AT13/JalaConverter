
# Project

## Prerequisites

For the project we need :

- Install Docker
- Install Docker-compose

If you have all the prerequisites, into this directoy you need to aply the next command in terminal:

>```ruby
> docker-compose -f dockercompose.yml up -d
>```

If you dont have all the prerequisites you can follow the next steps to install. 

# Docker


## 📝 How to install Docker on Windows

- Go to the nex link

>```ruby
> https://www.docker.com/products/docker-desktop
>```

- Press Download for Windows and install

### If you windows is Home

- https://www.youtube.com/watch?v=Gtid21ZOqpM

## 📝 How to install Docker on Ubuntu

### Prerequisites

* An Ubuntu 18.04 server following the Ubuntu 18.04 server initial setup guide, including a non-root sudo user and a firewall.

* An account on Docker Hub, if you want to create your own images and push to Docker Hub, as outlined in steps 7 and 8.

>```ruby
>$ sudo apt update
>```

>```ruby
>$ sudo apt install apt-transport-https ca-certificates curl software-properties-common
>```

>```ruby
>$ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
>```

>```ruby
>$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu bionic stable"
>```

>```ruby
>$ sudo apt update
>```

>```ruby
>$ apt-cache policy docker-ce
>```

>```ruby
>$ sudo apt install docker-ce
>```

>```ruby
>$ sudo systemctl status docker
>```

### Execute command docker with out sudo


>```ruby
>$ sudo usermod -aG docker ${USER}
>```


>```ruby
>$ su - ${USER}
>```

>```ruby
>$ id -nG
>```


>```ruby
>$ sudo usermod -aG docker username
>```


>```ruby
>$ docker --version
>```



## 📝 How to install Docker on Debian

### Prerequisites

* One Debian 10 server set up by following the Debian 10 initial server setup guide, including a sudo non-root user and a firewall.

* An account on Docker Hub if you wish to create your own images and push them to Docker Hub, as shown in Steps 7 and 8.

>```ruby
>$ sudo apt update
>```

>```ruby
>$ sudo apt install apt-transport-https ca-certificates curl software-properties-common
>```

>```ruby
>$ curl -fsSL https://download.docker.com/linux/debian/gpg | sudo apt-key add -
>```

>```ruby
>$ sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
>```

>```ruby
>$ sudo apt update
>```

>```ruby
>$ apt-cache policy docker-ce
>```

>```ruby
>$ sudo apt install docker-ce
>```

>```ruby
>$ sudo systemctl status docker
>```

### Execute command docker with out sudo


>```ruby
>$ sudo usermod -aG docker ${USER}
>```


>```ruby
>$ su - ${USER}
>```

>```ruby
>$ id -nG
>```


>```ruby
>$ sudo usermod -aG docker username
>```


>```ruby
>$ docker --version
>```
