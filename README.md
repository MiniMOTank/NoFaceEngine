# NoFaceEngine
a world only without graphic.(it's a game server)

##Dependencies
1. Scala programming language
2. ReactiveX library

##What's the special under the game engine?
With the CPU and GPU process speed grows and subtle. Server side also able to deal with Graphic matrix compute for thousand client player. This project I a attempt how much data able to hold on.

##Blueprint
* consider with tranditional compute except render image on graphic. So, it should be support transform compute, 
collision detection.
* It no-image world should be see as a rough debug view(good if showing better)

##What's the benefits compare with tranditional game server?
* needn't verify data valiable because client only need push raw input data and get result from server.
a lot of works for MMO game in server is verify data from client is belivable, such as position can't be too quickly, attack frequence should be reasonable, etc. It boring but important for fair. 
* union the world. server is a whole world(only can't see).We could ignore what should do at client side and what should do at server side.

##What's the difficulty to completed?
* integrated with GPU compute for excellent process speed.
* able to create a distributed system rather then single machine as client game engine.
* a lot of work same as a real game engine even though filter graphic render works.
