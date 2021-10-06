# theatrical_plays_android
# Android application 

1. [Home](#home)

2. [Actor](#actor)

3. Theater

4. Search

5. Movies

6. [Navigation_Bar](#navigation_bar)




## Navigation_Bar
Bottom navigation Bar that changes fragments


### HOME
Has 
1. Adapter for the recyclerview that connects, textViews and trailers with the Json file of databse
  a. Next to every trailer there is an arrow-button when isClicked expands a view with further description about its play.
3. class Fragment that shows the entire recyclerview with the above
4. There are seperate xml Files 
  a. For the fragment with recyclerView fragmentHome
  b. fragment_trailer for the view of its trailer

### Actor

1. Adapter Actor for the recyclerview that connects, textViews and images with the Json file of databse
  a. Every Actor has an name and image(if there is no image from the database there is a default) 
  b. Every item in Recyclerview is clicable
2. ActorFragment that shows the entire recyclerview with the above
3. With every click on actor displayed a page with details for him.
4. Activity_bio is an activity that loads information from database about the role and production that the clicked actor participates  

