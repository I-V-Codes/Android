Hawks Nest
==============
Final Project for EGE493 - Embedded Mobile Apps, Spring 2014

DESCRIPTION
==============
Hawks Nest allows current students and visitors to stay connected with the Residence Halls on the SUNY New Paltz campus. Although the Resident Life Department at SUNY New Paltz have their methods in informing students of future events, campus resources and contact information it has shown not to be effective. Many incoming and even returning New Paltz students are not aware of these programs and resources. Hawks Nest gives students the ability to stay inform of Residence Hall events, Residence Hall Staff contact information, a single place to find Campus Resources, and create the opportunity to get involved in the SUNY New Paltz community.

FEATURES
==============
<!--- Hawks Nest allows you to view the following for any Residents Hall:
  * Resident Assistants and Resident Director
  * Future Events
  * Important Campus Resources
  * Contact Information
  * Weekly Updates --->
  
Test Features
   * There are two types of users in this system: users and admins
   * Users may want to find out information about < People, Information, Events, Updates >
   * Admins need to create the relevant data, and maintain it.
   

Here is the user experience for a NEW student
   * App launches with a splash screen (branding of Residence Halls)
   * App Lobby shows a map of the campus highlighting the quads, and shows the number of halls in that quad
   * Clicking a quad shows a list of the residence halls in that quad (e.g., with a card for each)
   * Each residence hall shows you < ......>
   * User can browse available information by the following criteria < .... > 
   * User is asked to create an account -- gives himself a unique username
   * User is asked to select a residence hall .. picks from a list or from map
   * User is asked to select a set of services for that residence hall < resources, events ...>
   * User is taken to personalized lobby
   
here is the user experience for a KNOWN student (selected a hall)
   * user settings Load <Residence hall, Saved Events for notification reminders>
   * View any event for any Residence Hall. 
   * select desired events and favorite them in order to be reminded of them later.
   * View a desired Residence Hall staff and contact information. 
   * View Campus Resources including but not limited to UPD, PCC, Oasis and Haven. 

here is the user experience for an ADMIN
   * Each Resident Director on campus has an admin account. 
   * Through a pre-set up account the ADMIN will have editing access for their own Residence Hall.
   * The ADMIN can create and update Events, Contact Information, and Annoucnements.
   * selected Residence Hall to update information at
   * fill out form for adding events (date, time, name, location, description)

DATA MODEL
==============
<!---information on nouns, kinda of data and attributes, tables and columns that we need>
<Hawks Nest allows you to view the following for any Residents Hall:
  * Resident Assistants and Resident Director
  * Future Events
  * Important Campus Resources
  * Contact Information
  * Weekly Updates>
  
  <information on nouns, kinda of data and attributes, tables and columns that we need --->

Data Model:

    < ------------------------------------------ >    
      |                  USER                  |
    < ------------------------------------------ >  
      |Name                                    |
      |Role [Resident, RA, RD, None]           |  
      |Residence Hall [id or null]             | 
      |Residence Hall Room # [String or Null]  |
      |Extension # [Integer or Null]           |      
    < ------------------------------------------ >
                        |
                        |
                        V
    < ------------------------------------------ >    
      |             RESIDENCE HALL             |
    < ------------------------------------------ >  
      |Name                                    |
      |Quad                                    |  
      |Type of Residence Hall                  | 
      |Calendar                                |
      |RA                                      |
      |RD                                      |
    < ------------------------------------------ >  

             
             
 <!---The Calendar will be one Calendar with multiple URIs. One for the RA on Duty the other for Programming Events>            

<!---Database of dorms -> Database of Events
                  -> Database of Staff in that dorm -> Office Hours
                  -> Database of Information -> Phone numbers
                                              -> --->

  
VIEW
==============
New User
  Select Residence Hall --> Go to selected Residence hall --> Access Information according to the Residence Hall
Loading page for updating information
* Main page comes up with buttons for dorms:
   * Hasbrouck Complex
      * Bevier
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Crispell
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Deyo
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Dubouis
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Lefevre
         * Staff
         * Information
         * Events
         * Duty Calendar
   * Parker Complex
      * Bliss
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Gage
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Scudder
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Bouton
         * Staff
         * Information
         * Events
         * Duty Calendar
      * College
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Shango
         * Staff
         * Information
         * Events
         * Duty Calendar
   * South Complex
      * Esopus
         * Staff
         * Information
         * Events
         * Duty Calendar
      * Lenape
         * Staff
         * Information
         * Events
         * Duty Calendar

TEAM MEMBERS
==============
Matt Miccio <br />
Ivan Vivar <br />
Kenny Pan <br />
