# MySQL-Workbench-Docker-Setup
This repository will be a guide on setting up the [mysql](https://hub.docker.com/_/mysql/), and [mysql-workbench](https://hub.docker.com/r/linuxserver/mysql-workbench) docker containers and getting them to work with each other.

## Usage

### Creating the containers
Download the docker-compose.yml file or clone the repository and move the docker-compose.yml file to the directory in which you will be working. From here, we need to make some changes. Edit the docker-compose.yml file and set the mysql root password. This will be under the DB service, under environment and will look like this:
```yaml
#<*** in between code ***>
environment:
      - MYSQL_ROOT_PASSWORD=ETiWTtVotSoDiWFNE #currently the password is ETiWTtVotSoDiWFNE
#<*** in between code ***>
```

After that, set where you want to store the database files for mysql, as well as where you want to store the config files for the workbench. Currently they are set to be stored in ./db and ./config folders within the current directory. Each is under the service it belongs to, under volumes and will look like this:
```yaml
#<*** in between code ***>
 volumes:
      - ./db:/var/lib/mysql                     #where to store the database
#<*** in between code ***>
 volumes:
      - ./config:/config                        #where to store the config directory
#<*** in between code ***>
```

From there you should be good to go, although feel free to make more changes to fit your use case. Once you're satisfied with your docker-compose.yml setup, create and start the containers using the `docker compose up -d` command.


### Setup the Workbench container with the MySQL container
Caution: Construction in progess

### Access the MySQL shell via cli
For any use case in which you want to use the MySQL shell instead of using the workbench, you can access this by running the  command `docker exec -it <container-name-here> mysql -p` from your host's commandline. The docker exec command allows us to 'ssh' into the container, we then specify the command we want to run in the container `mysql -p` which will open the mysql shell and prompt login with the root password we set in the compose file.


####################################
https://docs.linuxserver.io/images/docker-mysql-workbench/#updating-info


All images:
docker-compose pull

All containers:
################################
docker-compose up -d




