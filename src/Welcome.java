import java.util.Scanner;

public class Welcome {
	static final int NUM_BOOK = 3;
	static final int NUM_ITEM = 7;
	static CartItem[] mCartItem = new CartItem[NUM_BOOK];
	static int mCartCount = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[][] mBook = new String[NUM_BOOK][NUM_ITEM];
		
		System.out.println("당신의 이름을 입력하세요 : ");
		String name = input.nextLine();
		
		System.out.println("연락처를 입력하세요");
		int phone = input.nextInt();
		
		String greeting = "Welcome to Shopping Mall";
		String tagline = "Welcome to Book Market!!";
		boolean quit = false;
		
		while (!quit) {
			System.out.println("********************************************");
			System.out.println("\t" + greeting);
			System.out.println("\t" + tagline);
			menuIntro();
			System.out.println("메뉴 번호를 선택하세요 : ");
			int choice = input.nextInt();
			if (choice < 1 || choice > 8) {
				System.out.println("1부터 8까지의 숫자를 입력하세요.");
			}
			else {
				switch(choice) {
				case 1:
					menuGuestInfo(name, phone);
					break;
				case 2:
					menuCartItemList();
					break;
				case 3:
					menuCartClear();
					break;
				case 4:
					menuCartBil();
					break;
				case 5:
					menuCartAddItem(mBook);
					break;
				case 6:
					menuCartRemoveItemCount();
					break;
				case 7:
					menuCartRemoveItem();
					break;
				case 8:
					menuExit();
					quit = true;
					break;
				}
			}
		}
	}
	
	
	public static void menuIntro() {
		System.out.println("********************************************");
		System.out.println("1. 고객 정보 확인하기\t5. 장바구니에 항목 추가하기");
		System.out.println("2. 장바구니 상품 목록 보기\t6. 장바구니의 항목 수량 줄이기");
		System.out.println("3. 장바구니 비우기\t7. 장바구니의 항목 삭제하기");
		System.out.println("4. 영수증 표시하기\t8. 종료");
		System.out.println("********************************************");
	}
	/**
	 * 설명 : 고객 정보 출력
	 * 매게변수 : 
	 * 	-String		name	고개 이름
	 * 	-int		phone	전화 번호
	 * 변환 :
	 */
	public static void menuGuestInfo(String name, int mobile) {
		System.out.println("1. 현재 고객 정보 : ");
		//System.out.println("이름 : " + name + ", 연락처 : " + phone);
		Person person = new Person(name, mobile);
		System.out.println("이름 : " + person.getName() + ", 연락처 : " + person.getPhone());
	}
	/**
	* 설명 : 장바구니 상품 목록
	* 매게변수 : 
	* 	-String		name	고개 이름
	* 	-int		phone	전화 번호
	* 변환 :
	*/
	public static void menuCartItemList() {
		System.out.println("장바구니 상품 목록 : ");
		System.out.println("-------------------------------------");
		System.out.println("	도서ID\t |	수량\t|	합계");
		for (int i = 0; i < mCartCount; i++) {
			System.out.print("	" + mCartItem[i].getBookID() + "\t| ");
			System.out.print("	" + mCartItem[i].getQuantity() + "\t| ");
			System.out.print("	" + mCartItem[i].getTotalPrice() + "\t| ");
			System.out.print("	");
		}
		System.out.println("-------------------------------------");
	}
	
	public static void menuCartClear() {
		System.out.println("3. 장바구니 비우기 : ");
	}

	public static void menuCartAddItem(String[][] book) {
		BookList(book);
		for (int i = 0; i < NUM_BOOK; i++) {
			for (int j = 0; j < NUM_ITEM; j++) {
				System.out.print(book[i][j] + "|");
			}
			System.out.println("");
		}
		
		boolean quit = false;
		
		while (!quit) {
			System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
			Scanner input = new Scanner(System.in);
			String str = input.nextLine();
			
			boolean flag = false;
			int numId = -1;
			
			for (int i = 0; i < NUM_BOOK; i++) {
				if (str.equals(book[i][0])) {
					numId = i;
					flag = true;
					break;
				}
			}
			
			if (flag) {
				System.out.println("장바구니에 추가하겠습니다? Y:N");
				str = input.nextLine();
				
				if(str.toUpperCase().equals("Y")) {
					System.out.println(book[numId][0] + " 도서가 장바구니에 추가되었습니다.");
					if (!isCartInBook(book[numId][0])) {
						mCartItem[mCartCount++] = new CartItem(book[numId]);
					}
				}
				quit = true;
			}
			else {
				System.out.println("다시 입력해 주세요");
			}
		}
	}
	
	public static boolean isCartInBook(String bookId) {
		boolean flag = false;
		for (int i = 0; i < mCartCount; i++) {
			if(bookId == mCartItem[i].getBookID()) {
				mCartItem[i].setQuantity(mCartItem[i].getQuantity() + 1);
				flag = true;
			}
		}
		return flag;
	}

	public static void menuCartRemoveItemCount() {
		System.out.println("6. 장바구니의 항목 수량 줄이기 : ");
	}

	public static void menuCartRemoveItem() {
		System.out.println("7. 장바구니의 항목 삭제하기 : ");
	}

	public static void menuCartBil() {
		System.out.println("4. 영수증 표시하기 : ");
	}

	public static void menuExit() {
		System.out.println("8. 종료 : ");
	}
	
	public static void BookList(String[][] book) {
		book[0][0] =  "ISBN1234";
		book[0][1] =  "쉽게 배우는 JSP 웹 프로그래밍";
		book[0][2] =  "27000";
		book[0][3] =  "송미영";
		book[0][4] =  "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍";
		book[0][5] =  "IT전문서";
		book[0][6] =  "2018/10/08";
		
		book[1][0] =  "ISBN1235";
		book[1][1] =  "안드로이드 프로그래밍";
		book[1][2] =  "33000";
		book[1][3] =  "우재남";
		book[1][4] =  "실습 단계별 명쾌한 멘토링!";
		book[1][5] =  "IT전문서";
		book[1][6] =  "2022/01/22";
		
		book[2][0] =  "ISBN1236";
		book[2][1] =  "스크래치";
		book[2][2] =  "22000";
		book[2][3] =  "고광일";
		book[2][4] =  "컴퓨팅 사고력을 키우는 블록 코딩";
		book[2][5] =  "컴퓨터입문";
		book[2][6] =  "2019/06/10";
	}
}