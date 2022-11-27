# About project
This is my pet-project website where you can buy, order, manage your flights.

## How to Run

I made up docker file for easy deployment of this application.
So all you need is to setup configuration in `docker-compose.yml` file:
> `YOURDB` - your database where application will add tables\
> `YOURUSR` - your username to the database\
> `YOURPASS` - your password to the database

Then you need browse to `/airline-ticket-reservation-website` folder, and run in cmd:
```
docker-compose up
```
