package codes;

import java.util.Scanner;

public class Lotto_review {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// 내 번호 저장할 배열 생성
		int[] myNumber = new int[6];
		// 숫자 6개 입력 받음. 입력 안내. 범위 내, 중복X 검사
		for(int i=0;i<myNumber.length;i++) {
			while(true) {
				System.out.print((i+1)+"번째 숫자를 입력해주세요(1~45) : ");
				int temp = scanner.nextInt();
				boolean isRange = (temp>=1)&&(temp<=45);
				boolean isDulp = true;
				for(int n : myNumber) {
					if(temp == n) {
						isDulp = false;
						break;
					}
				}
				if(isRange && isDulp) {
					myNumber[i] = temp;
					break;
				} else {
					if(!isRange) {
						System.out.println("범위를 벗어났습니다. 다시 입력해주세요(1~45).");
					} else {
						System.out.println("중복된 숫자입니다. 다시 입력해주세요.");
					}
				}
			}
		}
		// 당첨 번호 6개 골라서 배열에 입력
		// 당첨 번호를 저장할 배열 생성
		int[] winNumber = new int[6];
		// 범위는 1~45 인데, 이거는 생성할 때 조건 설정. 중복만 체크
		for(int i=0;i<winNumber.length;i++) {
			while(true) {
				int num = (int)(Math.random()*45) + 1;
				boolean isDulp = true;
				for(int n : winNumber) {
					if(num == n) {
						isDulp = false;
						break;
					}
				}
				if(isDulp) {
					winNumber[i] = num;
					break;
				}
			}
		}
		// 보너스 번호 랜덤 생성
		int bonusNum = 0;
		while(true) {
			int num = (int)(Math.random()*45) + 1;
			boolean isDulp = true;
			for(int n : winNumber) {
				if(num == n) {
					isDulp = false;
					break;
				}
			}
			if(isDulp) {
				bonusNum = num;
				break;
			}
		}
		
		// 당첨 번호를 출력할 때, 작은 숫자부터 오름차순으로 정렬. BubbleSort
		for(int i=0;i<winNumber.length;i++) {
			for(int j=0;j<winNumber.length-1;j++) {
				if(winNumber[j]>winNumber[j+1]) {
					int temp = winNumber[j];
					winNumber[j] = winNumber[j+1];
					winNumber[j+1] = temp;
				}
			}
		}
		// 당첨 번호를 출력
		for(int i=0;i<winNumber.length;i++) {
			System.out.print((i+1)+"번째 당첨 숫자 : ");
			System.out.println(winNumber[i]);
		}
		// 내 입력 번호와 당첨 번호를 맞춰보고 맞은 갯수별로 등수 출력
		int correctNum = 0;
		for(int myNum : myNumber) {
			for(int winNum : winNumber) {
				if(myNum == winNum) {
					correctNum++;
				}
			}
		}
		if(correctNum == 6) {
			System.out.println("1등 입니다.");
		} else if(correctNum == 5) {
			boolean correctBonus = false;
			for(int num : myNumber) {
				if(num == bonusNum) {
					correctBonus = true;
					break;
				}	
			}
			if(correctBonus) {
				System.out.println("2등 입니다.");
			} else {
				System.out.println("3등 입니다.");
			}
		} else if(correctNum == 4) {
			System.out.println("4등 입니다.");
		} else if(correctNum == 3) {
			System.out.println("5등 입니다.");
		} else {
			System.out.println("꽝 입니다.");
		}
	}
}












