
public class ExampleOne implements Runnable {
	
	String name;
	private Thread t;

	public ExampleOne(String name) {
		super();
		this.name = name;
		t = new Thread(this);
		t.start();
	}


	@Override
	public void run() {
		for(int i=0;i<10;i+=2){
			System.out.println("I am "+name+" : "+i);
			System.out.println("I am "+name+" : "+(i+1));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ExampleOne red = new ExampleOne("red");
		ExampleOne green = new ExampleOne("green");
	}

}
