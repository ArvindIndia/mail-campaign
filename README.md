
MYSQL - Server: 3306
D:\Softwares\mysql-8.0.13-winx64\bin>mysqld --initialize
D:\Softwares\mysql-8.0.13-winx64\bin>mysqld --console

MYSQL - Client:
D:\Softwares\mysql-8.0.13-winx64\bin>mysql -u root -p
Enter password: mysql@123

ZOOKEEPER: 2181
D:\Softwares\apache-zookeeper>bin\zkServer.cmd
KAFKA: 9092
D:\Softwares\apache-kafka>bin\windows\kafka-server-start.bat config\server.properties

ANGULAR - Server : 3000
For running server part.. go to server folder and run....  => node app
then node application will run on port 3000

ANGULAR - Front end : 4200
then go to front_end folder and run ... => npm run build:email 
D:\Arvind\Bridge\MakeathonDec2019\mailer-campaign\front_end>ng serve --proxy-config proxy.conf.json

GIT Repo
D:\Arvind\Bridge\MakeathonDec2019\gitrepo\gcloudsample>
echo "# gcloudsample" >> README.md
git init
git add *
git commit -m "first commit"
git remote add origin https://github.com/ArvindIndia/mailer-campaign.git
git push -u origin master

GCLOUD
gcloud config set project singular-range-264116
git clone https://github.com/ArvindIndia/gcloudsample
cd <project>
mvn clean package appengine:deploy
http://singular-range-264116.appspot.com/
gcloud compute firewall-rules create allow-http --allow tcp:80