package com.paytm.qapanel.service;

class CricketPlayers
{
    public static void main(String arg[])
    {
        Player players[] = new Player[11];

        players[0] = new Batsmen("Sachin", 250, 11324, 100, 125);
        players[1] = new Allrounder("Dhoni", 153, 6021, 120, 67);
        players[2] = new Batsmen("Shewag", 110, 4341, 22, 40);
        players[3] = new Batsmen("Yuvraj", 105, 6533, 15, 46);
        players[4] = new Batsmen("Kohli", 75, 4003, 25, 60);
        players[5] = new Batsmen("Raina", 34, 2600, 12, 19);
        players[6] = new Batsmen("Rohit", 25, 1500, 5, 9);
        players[7] = new Bowler("Harbhajan", 189, 1500, 320, 4);
        players[8] = new Bowler("Zaheer", 150, 900, 220, 4);
        players[9] = new Bowler("Umesh", 25, 150, 105, 2);
        players[10] = new Bowler("Aswin", 15, 200, 60, 2);

        for(Player player : players)
        {
            player.print();
            System.out.println();
            System.out.println("---------------------");

        }
    }
}

abstract class Player
{
    String name;
    int matchesPlayed;
    int runsScored;

    Player(String name, int matchesPlayed, int runsScored)
    {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }


    void bat()
    {
    }

    void makeSomeRuns()
    {
    }

    void print()
    {
        System.out.print(name  + " played " + matchesPlayed + " matches and scored " + runsScored + " runs.");
    }
}

class Batsmen extends Player
{
    int numberOfCenturies;
    int numberOfHalfCenturies;

    Batsmen(String name, int matchesPlayed, int runsScored, int numberOfCenturies, int numberOfHalfCenturies)
    {
        super(name, matchesPlayed, runsScored);
        this.numberOfCenturies = numberOfCenturies;
        this.numberOfHalfCenturies = numberOfHalfCenturies;
    }

    void openInnings()
    {
    }

    void makeCentury()
    {
    }

    void makeHalfCentury()
    {
    }

    void print()
    {
        super.print();
        System.out.print(" He is a strong batsmen and made " + numberOfCenturies +  " centuries and " + numberOfHalfCenturies + " half centuries.");
    }
}


class Bowler extends Player
{
    int numberOfWickets;
    int numberOf5WicketInnings;

    Bowler(String name, int matchesPlayed, int runsScored, int numberOfWickets, int numberOf5WicketInnings)
    {
        super(name, matchesPlayed, runsScored);
        this.numberOfWickets= numberOfWickets;
        this.numberOf5WicketInnings = numberOf5WicketInnings;
    }

    void openInnings()
    {
    }

    void bowlYorkers()
    {
    }

    void takeWickets()
    {
    }

    void print()
    {
        super.print();
        System.out.print(" He is also a good bowler and has taken " + numberOfWickets + " wickets. He has " + numberOf5WicketInnings + " 5WI(5-Wicket Innings) in his account.");
    }

}

class Allrounder extends Player
{
    int numberOfCatches;
    int numberOfStumpings;

    Allrounder(String name, int matchesPlayed, int runsScored, int numberOfCatches, int numberOfStumpings)
    {
        super(name, matchesPlayed, runsScored);
        this.numberOfCatches = numberOfCatches;
        this.numberOfStumpings = numberOfStumpings;
    }

    void keepWickets()
    {
    }

    void stumpBatsmen()
    {
    }

    void makeAppeals()
    {
    }

    void print()
    {
        super.print();
        System.out.print(" He also keeps the wickets and has " + numberOfCatches + " catches and " + numberOfStumpings + " stumpings in his account.");
    }
}
