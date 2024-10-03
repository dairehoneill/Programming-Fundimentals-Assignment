public class DvdShop
{
    //attributes (instance variables)
    private DVD[] dvdList;
    private int total;

    //Constructors
    public DvdShop(int sizeIn) 
    {
        dvdList = new DVD[sizeIn];
        total = 0;
    }

    //print variable
    public int getTotal() 
    {
        return total;
    }

    //adds a dvd to the array, aslong as theres space
    public boolean add(DVD dvd) 
    {
        if (isFull() == false) 
        {
            dvdList[total] = dvd;
            total++;
            return true;
        }
        else
        {
            return false;
        }
    }
    

    //searches for the dvd if found it removes
    public boolean remove(String dvdIdIn) 
    {
        int index = search(dvdIdIn);
        if (index == -999) 
        {
            return false;
        }
        else
        {
            for (int i = index; i < total - 1; i++) 
            {
                dvdList[i] = dvdList[i + 1];
            }
            total--;
            return true;
        }
    }

    // return if the list is empty
    public boolean isEmpty() {
        return total == 0;
    }

    // return if the list is full
    public boolean isFull() {
        return total == dvdList.length;
    }

    public DVD checkLongestDvd() 
    {
        DVD tempNULLDvd = null; // create temp variable for time check
        if (isEmpty() == false ) // check list
        {
            tempNULLDvd = dvdList[0]; // Copy first entry to temp variable
            for (int i = 1; i < total; i++) // Loop the rest of the DVD array
            {
                if (dvdList[i].getNumMinutes() > tempNULLDvd.getNumMinutes())  // compare if the dvdarray is bigger than the temp variable
                {
                    tempNULLDvd = dvdList[i]; //if true replace temp variable with dvdlist entry
                }
            }
        }
        return tempNULLDvd; // return entry
    }

    public DVD checkShortestDvd() 
    {
        DVD tempNULLODvd = null;// create temp variable for time check
        if (isEmpty() == false) // check list
        {
            tempNULLODvd = dvdList[0]; //copy first entry to temp variable
            for (int i = 1; i < total; i++) //loop the res of the dvd array
            {
                if (dvdList[i].getNumMinutes() < tempNULLODvd.getNumMinutes()) //compare if the dvdarray is bigger thant the temp variable
                {
                    tempNULLODvd = dvdList[i];//if true replace temp variable with devlist emtry
                }
            }
        }
        return tempNULLODvd;//return entry
    }

    
    //return a string containing all the books in the array.
    private int search(String dvdIdIn) {
        for (int S = 0; S < total; S++) {
            if (dvdList[S].getDvdId().equals(dvdIdIn)) 
            {
                return S;//if it retunes s (all the arrays) then it was successful
            }
        }
        return -999;//was not sucessful
    }

    
    public String list() 
    {
        String sList = "";
        if (isEmpty() == true) 
        {
            return  sList;
        }
        else
        {
            for (int i = 0; i < total; ++i)   //goes thorugh arrary and finds all the attributes of each object and adds them to a string to return
            {
                StringBuilder append = new StringBuilder().append(sList)
                    .append("DVD id: ").append(dvdList[i].getDvdId())
                    .append("\nDVD Name: ").append(dvdList[i].getDvdName())
                    .append("\nDVD Classification : ") .append(dvdList[i].getAgeClassification())
                    .append("\nDVD Category: ").append(dvdList[i].getCategory())
                    .append("\nDVD Review: ") .append(dvdList[i].getReview())
                    .append("\nLength of dvd: ").append(dvdList[i].getNumMinutes())
                    .append("\nNumber of years in shop: ");
                DVD dvd = dvdList[i];
                sList = append.append("\n\n\n").toString();
            }
        }
        return sList;
    }
    
   

    public DVD getItem(String dvdId) 
    {
        int index;
        index = search(dvdId);
        if (index == -999) 
        {
            return null; //indicates invalid index
        }
        else
        {
            return dvdList[index];
        }
    }

    public boolean addDetails(String dvdIdIn, int reviewIn) 
    {
        int index = search(dvdIdIn);
        if (index == -999) 
        {
            return false; //failed to find the dvd
        }
        else
        {
            dvdList[index].setReview(reviewIn);//sets the review in the details
            return true;
        }
    }
    
    
    public String dvdByClassification(int age) 
    {
        String list = "";
        if (isEmpty() == true) // if dvd empty return
        {
            return list;
        }
        else
        {
            for (int i = 0; i < total; ++i) //loop the array
            {
                if (dvdList[i].getAgeClassification() == age) //check if age matches the strong imput
                {
                    list = list + 
                    "DVD id: " + dvdList[i].getDvdId() +
                    "\nDVD Name: " + dvdList[i].getDvdName() + 
                    "\nDVD Classification : " + dvdList[i].getAgeClassification() + 
                    "\nDVD Category: " + dvdList[i].getCategory() + 
                    "\nDVD Review: " + dvdList[i].getReview() + 
                    "\nLength of dvd: " + dvdList[i].getNumMinutes() + 
                    "\n\n";
                }
            }
        }
        return list;
    }
}