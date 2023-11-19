FROM nginx:stable-alpine

# use a volume is mor efficient and speed that filesystem
VOLUME /tmp

#Install web app on nginx server
RUN rm -rf /usr/share/nginx/html/*

COPY nginx.conf /etc/nginx/nginx.conf
COPY dist /usr/share/nginx/html

#The ports 80 for web app
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]


