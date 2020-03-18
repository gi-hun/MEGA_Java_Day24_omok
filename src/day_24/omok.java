package day_24;

import java.util.Scanner;

public class omok {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] omok = new int[10][10];;
		
		int turn = 0;
		int win  = 0;
		
		while(true)
		{	
			System.out.println("  ====OMOK Game====");				//show Bingo Board
			System.out.print("  ");
			for (int i = 0; i < 10; i++) 
			{
				System.out.print(i + " ");
			}
			System.out.println();
			for (int i = 0; i < 10; i++) 
			{
				System.out.print(i + " ");
				for (int j = 0; j < 10; j++) 
				{
					System.out.print(omok[i][j] + " ");
				}
				System.out.println();
			}
			
			if(win == 1)			//player1 win
			{
				System.out.println("winner is player1");
				break;
			}
			else if(win == 2)			//player2 win
			{
				System.out.println("winner is player2");
				break;
			}
			
			if(turn%2 == 0)			//player1 turn
			{
				System.out.println("player1 x-coordinate");
				int p1x = sc.nextInt();
				System.out.println("player1 y-coordinate");
				int p1y = sc.nextInt();
				
				if(omok[p1y][p1x] == 0)
				{
					omok[p1y][p1x] = 1;
					turn++;
				}
				else
				{
					System.out.println("coordinate already entered");
				}
			}
			else if(turn%2 == 1)			//player2 turn
			{
				System.out.println("player2 x-coordinate");
				int p2x = sc.nextInt();
				System.out.println("player2 y-coordinate");
				int p2y = sc.nextInt();
				
				if(omok[p2y][p2x] == 0)
				{
					omok[p2y][p2x] = 2;
					turn++;
				}
				else
				{
					System.out.println("coordinate already entered");
				}
			}
			
			//오목을 이기기 위한 조건
			//1)가로 '연속적으로' 5개가 같은 숫자
			//i is 'y',    j is 'x'
			for(int i=0;i<10;i++)
			{
				for(int j=4;j<10;j++)
				{
					if(omok[i][j-4] == 1 && omok[i][j-3] == 1 && omok[i][j-2] == 1 && omok[i][j-1] == 1 && omok[i][j] == 1)
					{
						win = 1;
					}
					if(omok[i][j-4] == 2 && omok[i][j-3] == 2 && omok[i][j-2] == 2 && omok[i][j-1] == 2 && omok[i][j] == 2)
					{
						win = 2;
					}
				}
			}
			//2)세로 '연속적으로' 5개가 같은 숫자
			for(int i=4;i<10;i++)
			{
				for(int j=0;j<10;j++)
				{
					if(omok[i-4][j] == 1 && omok[i-3][j] == 1 && omok[i-2][j] == 1 && omok[i-1][j] == 1 && omok[i][j] == 1)
					{
						win = 1;
					}
					if(omok[i-4][j] == 2 && omok[i-3][j] == 2 && omok[i-2][j] == 2 && omok[i-1][j] == 2 && omok[i][j] == 2)
					{
						win = 2;
					}
				}
			}
			//3)대각선 '연속적으로' 5개가 같은 숫자
			
			//3-1) 대각선 방향이 아래일때
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(omok[i][j] == 1 && omok[i+1][j+1] == 1 && omok[i+2][j+2] == 1 && omok[i+3][j+3] == 1 && omok[i+4][j+4] == 1)
					{
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2)
					{
						win = 2;
					}
				}
			}
			
			//3-2) 대각선 방향이 위일때
			for(int i=4;i<10;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(omok[i][j] == 1 && omok[i-1][j+1] == 1 && omok[i-2][j+2] == 1 && omok[i-3][j+3] == 1 && omok[i-4][j+4] == 1)
					{
						win = 1;
					}
					if(omok[i][j] == 2 && omok[i-1][j+1] == 2 && omok[i-2][j+2] == 2 && omok[i-3][j+3] == 2 && omok[i-4][j+4] == 2)
					{
						win = 2;
					}
				}
			}
			
		}//무한 반복 종료 시점
		
	}
}
