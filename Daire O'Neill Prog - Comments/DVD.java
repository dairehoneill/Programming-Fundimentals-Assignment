public class DVD
{
    //instance variables
    private String dvdId;
    private String dvdName;
    private int ageClassification;
    private String category;
    private int numMinutes;
    private int review;
    
    //this is the constructor for the DVD class initialises the instance variables
    public DVD( String dvdIdIn,  String nIn,  String categoryIn,  int ageClassificationIn,  int numMinutesIn)
    {
        dvdId = dvdIdIn;
        dvdName = nIn;
        category = categoryIn;
        ageClassification = ageClassificationIn;
        numMinutes = numMinutesIn;
        review = 0;
    }
    
    public void setDvdId( String dvdIdIn) 
    {
        dvdId = dvdIdIn;
    }
    
    public String getDvdId() 
    {
        return dvdId; //Returns the contents of the dvdid instance variable
    }
    
    public void setDvdName( String dvdNameIn) 
    {
        dvdName = ""; //sets the data to empty
        dvdName = dvdNameIn; //updates dvd name variable equal to the input 
    }
    
    public String getDvdName() 
    {
        return dvdName;  //Returns the contents of the dvdname instance variable
    }
    
    public int getAgeClassification() 
    {
        return ageClassification;  //Returns the contents of the ageclassification instance variable
    }
    
    public void setAgeClassification(int ageClassificationIn) 
    {
        ageClassification = 0; //sets the data to 0
        ageClassification = ageClassificationIn; //updates the data passed in the parameter field
    }
    
    public String getCategory() 
    {
        return category; //Returns value of variable
    }
    
    public void setCategory(String categoryIn) 
    {
        category = categoryIn;   //updates the data passed in the parameter field
    }
    
    public int getReview() 
    {
        return review; //Returns the contents of the review instance variable
    }
    
    public void setReview(int reviewIn) 
    {
        review = reviewIn;   //updates the data passed in the parameter field
    }
    
    public int getNumMinutes() 
    {
        return numMinutes; //Returns the contents of the number of minutes instance variable
    }
    
    public void setNumMinutes(int numMinutesIn) 
    {
        numMinutes = numMinutesIn;   //updates the data passed in the parameter field
    }
}