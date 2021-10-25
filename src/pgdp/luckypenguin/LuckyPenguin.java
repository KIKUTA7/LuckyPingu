package pgdp.luckypenguin;

import static pgdp.MiniJava.*;

public class LuckyPenguin {
	public static void main(String[] args) {
		int num = readInt("Number of penguins:");
		while (num <= 1) {
			num = readInt("Number of penguins should be >1:");

		}
		int per = readInt("Starting fish per penguin:");
		while (per <= 0) {
			per = readInt("Starting fish should be >0:");
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
			System.out.println("It's penguin "+k+" turn:");
			int stop = 0;
			for (int i=0; i<num;i++)
			{
				if(checkpingu[i] == 1) stop++;
			}
			if(stop == num - 1)
			{
				System.out.println("You are the last penguin to play! You win all the fish on the board!");
				for(int i=1;i<10;i++)
				{
					pingu[k] += fish[i];
				}
				t = true;
				continue;
			}
			fir = dice();
			sec = dice();
			sum = fir + sec;
			System.out.println(fir+" + "+sec+" = "+sum+" was rolled.");
			if (sum == 12)
			{

				System.out.println("King Penguin! You win all the fish on the board!");
				for (int i=1;i<10;i++)
				{
					pingu[k] += fish[i];
				}

			}
			else if (sum == 2)
			{
				System.out.println("Lucky penguin! You win all fish on the board except F7!");
				for (int i=1;i<10;i++)
				{
					if(i == 5) continue;
					pingu[k] += fish[i];
				}
			}
			else if (sum == 7)
			{
				System.out.println("Wedding! You give a fish and place it on F7.");
				fish[5]++;
				pingu[k]--;
			}
			else if (fish[sum - 2] == 0)
			{
				System.out.println("You put a fish on F"+sum+".");
				pingu[k]--;
				fish[sum - 2]++;
			}
			else
			{
				System.out.println("They take the fish from F"+sum+".");
				pingu[k]++;
				fish[sum - 2]--;
			}
			System.out.println("You now have "+pingu[k]+" fishes!");
			if (pingu[k] == 0)
			{
				System.out.println("You have lost all fish, so you can no longer play!");
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
		int last = 0;
		for (int i=0; i < num; i++)
		{
			if (pingu[i] > WinningNum) {WinningNum = pingu[i]; }
			else if(pingu[i] == WinningNum) {last = i;}
		}
		System.out.println("The winning penguins with "+WinningNum+" fish:");
		for (int i=0; i<num ; i++)
		{
			if(pingu[i] == WinningNum)
			{
				if(i == last) {System.out.print("Penguin "+i);}
				else {System.out.println("Penguin "+i);}
			}
		}




	}
}
