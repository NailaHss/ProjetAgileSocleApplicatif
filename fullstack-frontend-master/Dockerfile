#Stage 1 - build
FROM node:17-alpine as builder 
WORKDIR /app
COPY package.json .
RUN npm install
COPY . .
#RUN npm run build
# Install dependencies (npm ci makes sure the exact versions in the lockfile gets installed)
RUN npm ci 
# Build the app
RUN npm run build
# ==== RUN =======
# Set the env to "production"
ENV NODE_ENV production
# Expose the port on which the app will be running (3000 is the default that serve uses)
EXPOSE 3000
# Start the app
CMD [ "npx", "serve", "build" ]

#Stage 2 - deplyoment
#FROM nginx:1.19.0
#WORKDIR /usr/share/nginx/html
#RUN rm -rf ./*
#COPY --from=builder /app/build .
#ENTRYPOINT [ "nginx","-g","daemon off;" ]