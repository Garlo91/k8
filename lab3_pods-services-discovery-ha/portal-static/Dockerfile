FROM ubuntu
RUN apt-get update
RUN apt-get install nginx -y
COPY imagine/css /var/www/html/css
COPY imagine/fonts /var/www/html/fonts
COPY imagine/images /var/www/html/images
COPY imagine/js /var/www/html/js
COPY imagine/scss /var/www/html/scss
COPY imagine/main.html /var/www/html/main.html
COPY imagine/prepros-6.config /var/www/html/prepros-6.config
COPY imagine/index.html /var/www/html/
EXPOSE 80
CMD ["nginx","-g","daemon off;"]