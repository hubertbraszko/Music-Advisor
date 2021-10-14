# Music Advisor


## Description

Music Advisor Project for Learning how to work with API's.
This application communicates with spotify API, and gets you links and basic information about music based on your Spotify Account

## How to build and run 

1. Clone the repository
2. Inside the repository run ```./gradlew build``` and then ```./gradlew run```
3. Navigate through the app using following commands:

- new - a list of new albums with artists and links on Spotify
- featured - a list of Spotify-featured playlists with their links fetched from API
- categories - a list of all available categories on Spotify (just their names)
- playlists <CATEGORY_NAME> - where CATEGORY_NAME is the name of category. The list contains playlists of this category and their links on Spotify
- auth - perform user authetication **FIRST COMMAND TO RUN AS IT MAKES ALL THE OTHER COMMANDS AVAILABLE**
- next - navigates to next page
- prev -navigates to previous page
- exit - shuts down the application

**IMPORTANT NOTE** When first running the App u have to provide the ```CLIENT_ID``` and ```CLIENT_SECRET``` in the Config.java file with values that you can get from https://developer.spotify.com/.

## Example output
">" character represents the user input. Note that it's not part of the input.

```
> new
Please, provide access for application.
> auth
use this link to request the access code:
https://accounts.spotify.com/authorize?client_id=a19ee7dbfda443b2a8150c9101bfd645&redirect_uri=http://localhost:8080&response_type=code
waiting for code...
code received
Making http request for access_token...
Success!
> new
OT ALL HEROES WEAR CAPES
[Metro Boomin, Travis Scott, 21 Savage]
https://open.spotify.com/album/1zNr37qd3iZJ899byrTkcj

I Used To Know Her - Part 2 - EP
[H.E.R.]
https://open.spotify.com/album/46imFLgb9fR1Io6EoPYeQh

The Last Rocket
[Takeoff]
https://open.spotify.com/album/5XRCcUfwtLNQflDd9cfz4U

Interstate Gospel
[Pistol Annies]
https://open.spotify.com/album/0IXxmmlfSQxgJNWnNjHhgJ

El Mal Querer
[ROSALÍA]
https://open.spotify.com/album/355bjCHzRJztCzaG5Za4gq

---PAGE 1 OF 5---
> prev
No more pages.
> next
Mountains
[Sia, Diplo, Labrinth]
https://open.spotify.com/album/3dB0bCgmpEgCSr3aU1bOtv

Pussy Is God
[King Princess]
https://open.spotify.com/album/4UzCY6ikiEN4rgY26I4jg0

Shootin Shots (feat. Ty Dolla $ign & Tory Lanez)
[Trey Songz, Ty Dolla $ign]
https://open.spotify.com/album/6Erhbwa5HmDwuzYacUpLPr

Runaway
[Lil Peep]
https://open.spotify.com/album/38sesm68q3lg21o6Lpzslc

RESET
[Moneybagg Yo]
https://open.spotify.com/album/547DJFUYOl2SBYJbo2jZX1

---PAGE 2 OF 5---
> categories
Top Lists
Mood
Chill
Hip-Hop
Electronic/Dance
---PAGE 1 OF 10---
> next
Kids & Family
Rock
Indie
Happy Holidays
Workout
---PAGE 2 OF 10---
> exit
```

