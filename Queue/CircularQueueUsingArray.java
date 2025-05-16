package Queue;

public class CircularQueueUsingArray {
    static class Queue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        Queue(int n){
            arr=new int[n];
            size=n;
            rear=front=-1;
        }
        public boolean isEmpty(){
            return rear==-1 && front ==-1;
        }
        public boolean isFull(){
            return (rear+1)%size ==front;
        }
        public void add(int data){
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            if(front==-1){
                front=0;
            }
            rear=(rear+1)%size;
            arr[rear]=data;
        }
        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int target=arr[0];
            if(rear==front){
                rear=front=-1;
            }
            else {
                front=(front+1)%size;
            }
            return target;
        }
        public int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (!q.isEmpty()){
            System.out.println(q.remove());
        }
    }
}
