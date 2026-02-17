class MyCircularQueue {

    int[] arr;
    int front;
    int rear;
    int count;
    int size;

    public MyCircularQueue(int k) {
        size = k;
        arr = new int[k];
        front = 0;
        rear = 0;
        count = 0;
    }

    // Insert an element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;

        arr[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }

    // Delete an element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % size;
        count--;
        return true;
    }

    // Get the front item
    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Get the last item
    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(rear - 1 + size) % size];
    }

    // Checks whether the circular queue is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Checks whether the circular queue is full
    public boolean isFull() {
        return count == size;
    }
}
