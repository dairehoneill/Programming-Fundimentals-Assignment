public class XtraVisonApplication
{

    public static void main(String[] args) 
    {
        System.out.print("Enter the maximum number of dvds that can be stored in the shop: ");//asks you the maximum amout of dvds you want stored
        int size;//sets size, the number you're asked to put in is only a number
        size = EasyScanner.nextInt();//calls the easyscanner, asks user to put in the maximum amount of dvds
        final DvdShop dvdList = new DvdShop(size);//calls the dvd shop and sets up the object
        int choice;//allows you to choose 1-9

        do //makes you choose 1-8 on loop until you choose 9
        {
            System.out.println();//line for neatness
            System.out.println("DVD System");//title
            System.out.println("1. Add a DVD");//allows you to add a dvd
            System.out.println("2. Remove a DVD");//allows you to remove a dvd
            System.out.println("3. Check if DVD Shop is empty");//allows you to check if the dvd shop is empty
            System.out.println("4. Check if DVD Shop is full");//allows you to check if the dvd shop is full
            System.out.println("5. Add Additional DVD Details");//allows you to add additional dvd details
            System.out.println("6. DVD Details");//allows you to see all the dvd details
            System.out.println("7. Update DVD Length of Time in Store ");//allows you to update length of dvd time in store
            System.out.println("8. Search DVD by Age Classification ");//allows you to search dvd by age classification
            System.out.println("9. Exit System");//allows you to exit system
            System.out.println();//line for neatness
            System.out.print("Please enter choice [1-9 only]: ");//tells you to pick between 1-9 for options
            choice = EasyScanner.nextInt();
            System.out.println();//line for neatness

            //process menu options
            switch (choice) //this allows you to check the list of variables
            {
                case 1: 

                addDVD(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 2: 

                removeDVD(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 3: 

                checkEmpty(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 4: 

                checkFull(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 5: 

                addDetails(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 6: 

                details(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 7: 

                updateLength(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 8:

                SearchByAge(dvdList);//switch valid imput select specific method and proceed with action
                break;

                case 9:

                break;

                default: //tells you your answer is invalid if you don't put in 1-9

                System.out.println("Invalid entry, please enter 1 - 9 only");
                break;

            }
        } while (choice != 9);//loop continues until you choose 9
        System.out.println("Thank you for using the DVD system");
    }
    //end of main method

    public static void addDVD(DvdShop myDvdShop)//adds a dvd
    {
        String id1;
        String name;
        String categ;
        int agec;
        int numm;
        boolean ok;

        System.out.print("Enter dvd id: ");//asks you for the dvds id
        id1 = EasyScanner.nextString();

        System.out.print("Enter DVD name  : ");//asks you for the dvds name
        name = EasyScanner.nextString();

        System.out.print("Enter DVD category  : ");//askd you for the dvd category
        categ = EasyScanner.nextString();

        System.out.print("Enter DVD age classification  : ");//asks you for the age classification
        //must be a number
        for (agec = EasyScanner.nextInt(); agec != 12 &&agec != 15 && agec != 18; agec = EasyScanner.nextInt()) 
        {//this means that you can only enter 12,15 or 18
            System.out.print("Please enter a valid classification (12, 15, or 18) :");//tells you theres an error if you haven't entered in one of the three options
        }

        System.out.print("Enter DVD running time (in minutes): ");//asks you for the runtime of the dvd
        numm = EasyScanner.nextInt();

        DVD dvd1 = new DVD(id1, name, categ, agec, numm);//this shows all the infomation is stored
        System.out.println();

        ok = myDvdShop.add(dvd1);//calling the add method from dvdshop

        System.out.println();

        if (ok == false) 
        {
            System.out.println("Can not add new DVD. This list is full");//this means you are at max capacity of dvds and the dvd won't be added
        }
        else 
        {
            System.out.println("DVD Added");// this means the dvd has been successfully added
        }
    }

    public static void removeDVD(DvdShop myDvdShop) //removes a dvd
    {
        boolean ok3;

        System.out.print("Enter DVD id to remove: ");//asks you to put in the id of the dvd you've made
        String dvdIdnum = EasyScanner.nextString();
        ok3 = myDvdShop.remove(dvdIdnum);//this removes the dvd based on the id number
        if (ok3 == false) 
        {
            System.out.println("Cannot delete DVD as no such DVD exist");//this will come up if you have not made a dvd yet, or you entered the id wrong
        }
        else 
        {
            System.out.println("DVD with id number " + dvdIdnum + " is removed");//this shows that the dvd has been successfully removed
        }
    }

    public static void checkEmpty(DvdShop myDvdShop) //checks if the shop is empty
    {
        boolean check;

        check = myDvdShop.isEmpty();//calls the method in dvdshop

        if (check == true) //if theres no dvds in the shop then it will come up empty, but if there is it will come up as not empty
        {
            System.out.println("The DVD Shop is empty");
        }
        else 
        {
            System.out.println("The DVD Shop is not empty");
        }
    }

    public static void checkFull(DvdShop myDvdShop) //checks if the shop is full
    {
        boolean check;

        check = myDvdShop.isFull();//calls the method in dvdshop

        if (check == true) //if theres no dvds in the shop then it will come up full, but if there is it will come up as not full
        {

            System.out.println("The DVD Shop is full");
        }
        else 
        {
            System.out.println("The DVD Shop is not full");
        }
    }

    private static void addDetails(DvdShop myDvdShop)//adds extra details to the dvd (what the shop revies it as)
    {
        String idS;
        boolean ok1;
        int reviewS;

        System.out.println();
        System.out.print("Enter DVD Id: ");//this asks for the id of the dvd you want to add the review to
        idS = EasyScanner.nextString();

        System.out.print("Enter DVD Review ");
        reviewS = EasyScanner.nextInt();

        ok1 = myDvdShop.addDetails(idS,reviewS);//this calls the addDetails method

        System.out.println();

        if(ok1 == false)
        {
            System.out.println("DVD could not be found");
        }
        else
        {
            System.out.println("DVD details updated");//this shows that you sucessfully added your review
        }
    }

    private static void details(DvdShop myDvdShop) //this gives you all the options in the menu
    {
        System.out.println();
        System.out.println("Employee System");
        System.out.println("1. Add a DVD");
        System.out.println("2. Remove a DVD");
        System.out.println("3. Check if DVD Shop is Empty");
        System.out.println("4. Check if DVD Shop is Full");
        System.out.println("5. Add Additional DVD Details");
        System.out.println("6. DVD Details");
        System.out.println("\t a. Display Details of a DVD ");
        System.out.println("\t b. Display All DVD Details");
        System.out.println("\t c. Display Longest Running DVD ");
        System.out.println("\t d. Display Shortest Running DVD  ");
        System.out.println("7. Update DVD Length of Time in Store ");
        System.out.println("8. Search DVD by Age Classification ");
        System.out.println("9. Exit System");

        System.out.print("Enter choice [a,b,c or d]: ");//asks you to put in one of these options
        char choice2 = EasyScanner.nextChar();
        System.out.println();

        switch (choice2) 
        {
            case 'a': 

            DetailOfA(myDvdShop);
            break;

            case 'b': 

            DisplayAll(myDvdShop);
            break;

            case 'c': 

            longest(myDvdShop);
            break;

            case 'd': 

            shortest(myDvdShop);
            break;

            default: 

            System.out.println("Invalid entry, please enter a -d only");
            break;
        }
    }

    private static void DetailOfA(DvdShop myDvdShop) //gives you the detail of a single dvd
    {
        String num1;
        DVD tdvd1;

        System.out.println();

        System.out.println("Enter DVD id to display the DVDs information");
        num1 = EasyScanner.nextString();

        System.out.println();

        tdvd1 = myDvdShop.getItem(num1);//calls getItem from dvdshop

        if(tdvd1 == null)//if the dvd wasn't then null would be true
        {
            System.out.println("No such DVD is in the system");
        }
        else
        {
            System.out.println("ID is" +tdvd1.getDvdId());
            System.out.println("Name is" +tdvd1.getDvdName());
            System.out.println("Age Classification is" +tdvd1.getAgeClassification());
            System.out.println("Category is" +tdvd1.getCategory());
            System.out.println("Runtime is" +tdvd1.getNumMinutes());
        }
    }

    private static void DisplayAll(DvdShop myDvdShop) //this displays all the dvds in the system
    {

        String allDetails;

        allDetails = myDvdShop.list();

        if(allDetails.equals("") == true)
        {
            System.out.println("There are no DVDs in the system");
        }
        else
        {
            System.out.print(allDetails);
        }

    }

    private static void longest(DvdShop myDvdShop) //this shows the longest dvd
    {
        DVD temp = myDvdShop.checkLongestDvd();
        if (temp == null)
        {
            System.out.println("No DVD are added into the system");
        }
        else 
        {
            System.out.println(temp.getDvdName() + " with dvd id " + temp.getDvdId() + " is the longest running dvd (" + temp.getNumMinutes() + " minutes )");
        }
    }

    private static void shortest(DvdShop myDvdShop) //this shows the shortest dvds
    {
        final DVD temp = myDvdShop.checkShortestDvd();
        if (temp == null) 
        {
            System.out.println("No DVD are added into the system");
        }
        else 
        {
            System.out.println(temp.getDvdName() + " with dvd id " + temp.getDvdId() + " is the shortest running dvd (" + temp.getNumMinutes() + " minutes )");
        }
    }

    public static void updateLength(DvdShop myDvdShop)//this update the length of time the dvd store has it
    {
        int len;

        System.out.print("Enter updated length of time in store: ");
        len = EasyScanner.nextInt();
        System.out.println();
        System.out.println("The length of time have been updated");

    }

    public static void SearchByAge(DvdShop myDvdShop) //this only lets you see dvds that are the age you select
    {

        int  ageClassification;
        String resultX;

        System.out.print("Enter age classification of DVDs to view: ");  
        ageClassification = EasyScanner.nextInt();
        resultX = myDvdShop.dvdByClassification(ageClassification);
        if (resultX  == ("")) 
        {
            System.out.println();
            System.out.println("There are no DVDs for the age classification " + ageClassification);
        }
        else 
        {
            System.out.println("There DVDs for the age classification " + ageClassification + " are as follows");
            System.out.println(resultX);
        }
    }
}
//end class