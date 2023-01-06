./mvnw clean
./mvnw package -Dmaven.test.skip=true
docker stop item_container
docker rm item_container
docker rmi item-app
docker build -t item-app:latest .
docker run -d -p 3000:3000 --name item_container -t item-app
