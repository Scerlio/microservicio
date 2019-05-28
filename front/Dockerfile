FROM node:10.13-alpine
ENV http_proxy http://alca.proxy.corp.sopra:8080/ 
ENV https_proxy http://alca.proxy.corp.sopra:8080/
WORKDIR /app
EXPOSE 4200
COPY ./ /app/
RUN npm install
ENTRYPOINT npm start 