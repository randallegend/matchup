## Installation
1. Clone the repository: Android Studio -> File -> New -> Project from Version Control -> Repository Url 
2. Copy -> [https://github.com/randallegend/matchup.git](https://github.com/randallegend/matchup.git) -> Clone

## Customization
1. You can change the cardview design but dont change the id.
2. After importing your own 6 images, you need to rename the resource of the default images in the drawable card_ ..xml and in the GameActivity.java. Below are the examples of what you need to change:
   - ### card_monkey.xml
     ```xml
      <selector xmlns:android="http://schemas.android.com/apk/res/android">
          <item android:state_selected="true" android:drawable="@drawable/monkey"/>  <!-- Change the drawable name to your image name -->
          <item android:state_selected="false" android:drawable="@drawable/forest"/> <!-- Change the drawable name to your default image name -->
      </selector>
     ```
   - ### GameActivity.java | at line 142
     ```java
       private List<Card> getCardList(){
          cardList.clear();
          List<Card> list = new ArrayList<>();
          HashMap<String, Integer> map = new HashMap<>();
          map.put("Monkey", R.drawable.card_monkey); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          map.put("Beetle", R.drawable.card_beetle); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          map.put("Chameleon", R.drawable.card_chameleon); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          map.put("Cobra", R.drawable.card_cobra); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          map.put("Raccoon", R.drawable.card_raccoon); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          map.put("Tiger", R.drawable.card_tiger); //change to your respective card name (e.g "Alien", R.drawable.card_alien)
          for(String s : map.keySet()){
              list.add(new Card(s, map.get(s)));
              list.add(new Card(s, map.get(s)));
          }
  
          return list;
      }
     ```
     

# Be productive, code lang yan, tayo'y Boolboolean

