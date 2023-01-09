# Stage 1
FROM node:alpine AS builder
WORKDIR /usr/local/app
COPY . /usr/local/app
RUN npm install --legacy-peer-deps
RUN npm run build --prod --outputHashing=all
# Stage 2
FROM nginx:alpine
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /usr/local/app/dist/bantads-webapp /usr/share/nginx/html
EXPOSE 80