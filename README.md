# Multi-threaded mill simulator.
This program simulates the operation of a mill in multi-threaded mode.
+ The user interface is created using Nuxt.js and is located in the folder **mill_ui**.
+ The server part of the application is implemented using multithreading and the Spring framework <br> 
and is located in the folder **mill**.
+ Interaction between the client and server parts is carried out using web sockets.
+ To obtain flour using mill you need:
  + add water to work the water wheel
  + the water wheel turns on the mechanism that turns millet into flour
  + to get flour, you need to add millet while the mill is running