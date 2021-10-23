package pgdp.luckypenguin;

public class LuckyPenguin extends MiniJava {
    public static void main(String[] args) {
        int num = readInt("Number of penguins:");
        while (num <= 1) {
            num = readInt("Number of penguins should be >1:");

        }
        int per = readInt("Starting fish per penguin:");
        while (per <= 0) {
        	per = readInt("Start fish should be >0:");
        }
        int pingu [] = new int [num];
        for (int i=0;i<num;i++)
		{
			pingu[i] = per;
		}
        boolean t=false;
        int fish [] = new int [11];
        int checkpingu [] = new int [num];
        int k=0;
        int fir,sec;
        while (t==false)
		{
			if (checkpingu[k] == 1) {k++;continue;}
			int sum = 0;
			writeBoard(fish[1],fish[2],fish[3],fish[4],fish[5],fish[6],fish[7],fish[8],fish[9]);
			write("It's penguin "+k+"'s turn:");
			int stop = 0;
			for (int i=0; i<num;i++)
			{
				if(checkpingu[i] == 1) stop++;
			}
			if(stop == num - 1)
			{
				write("You are the last penguin to play! You win all the fish on the board!");
				for(int i=1;i<10;i++)
				{
					pingu[k] += fish[i];
				}
				t = true;
			}
			fir = dice();
			sec = dice();
			sum = fir + sec;
			write(fir+" + "+sec+" = "+sum+" was rolled.");
			if (sum == 12)
			{

				write("King Penguin! You win all the fish on the board!");
				for (int i=1;i<10;i++)
				{
					pingu[k] += fish[i];
				}

			}
			else if (sum == 2)
			{
				write("Lucky penguin! You win all fish on the board except F7!");
				for (int i=1;i<10;i++)
				{
					if(i == 5) continue;
					pingu[k] += fish[i];
				}
			}
			else if (sum == 7)
			{
				write("Wedding! You give a fish and place it on F7.");
				fish[5]++;
				pingu[k]--;
			}
			else if (fish[sum - 2] == 0)
			{
				write("You put a fish on F"+sum);
				pingu[k]--;
				fish[sum - 2]++;
			}
			else
			{
				write("You take the fish from F"+sum);
				pingu[k]++;
				fish[sum - 2]--;
			}
			write("You now have "+pingu[k]+" fish!");
			if (pingu[k] == 0)
			{
				write("You have lost all fish, so you can no longer play!");
				checkpingu[k] = 1;
			}
			else
			{
				int check = readInt("Enter 1 to exit now:");
				if (check == 1) {checkpingu[k] = 1;}
			}
			k++;
			if(k == num) k=0;

		}
        int WinningNum = pingu[0];
        for (int i=0; i < num; i++)
		{
			if (pingu[i] > WinningNum) {WinningNum = pingu[i];}
		}
        int WinnerNum = 0;
        write("The winning penguins with "+WinningNum+" fish:");
		for (int i=0; i<num ; i++)
		{
			if(pingu[i] == WinningNum)
			{
				write("Penguin "+(i+1));
			}
		}



    }
}
