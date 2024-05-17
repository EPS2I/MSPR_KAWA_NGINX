FROM nginx

COPY conf/nginx.conf /etc/nginx/nginx.conf
COPY html/50x.html /etc/nginx/html/50x.html

EXPOSE 8082

CMD ["nginx", "-g", "daemon off;"]