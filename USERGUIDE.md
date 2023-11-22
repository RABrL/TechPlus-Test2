# Welcome to Tech+ Query Builder!

In this repository I have developed an app to build queries to a BigQuery database with a form in an intuitive and friendly way.
It is constituted by a Front app developed in Astro the web framework using react components, a Java back which connects to a PostgreSQL database. 

## How start
To run this project locally, you need to have docker and docker-compose installed. also you need create a .env file with your variables to look what variables view the *.en.example* file

First of all clone the repository

    git clone https://github.com/RABrL/TechPlus-Test2.git

After cloning the repo and set your .env file, run the following commands to start

    docker compose up --build -d
and that's all your proyect is already running locally on http://localhost:9000 port.
## How to use the App

This project is not finished yet, I had some problems with BigQuery and I haven't been able to solve them yet but the API I built in the back works perfectly connected to the PostgreSQL database but I haven't consumed it in the front yet. Anyways, you can try it running the endpoints in api.http file.

## Video URL of preview app
[LINK](https://youtu.be/0SbZjS2Mdc0)
