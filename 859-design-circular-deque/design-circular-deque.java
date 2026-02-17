class MyCircularDeque {

    int[] arr;
    int front;
    int rear;
    int count;
    int size;

    public MyCircularDeque(int k) {
        size = k;
        arr = new int[k];
        front = 0;
        rear = 0;
        count = 0;
    }

    // Adds an item at the front
    public boolean insertFront(int value) {
        if (isFull()) return false;

        front = (front - 1 + size) % size;
        arr[front] = value;
        count++;
        return true;
    }

    // Adds an item at the rear
    public boolean insertLast(int value) {
        if (isFull()) return false;

        arr[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }

    // Deletes an item from the front
    public boolean deleteFront() {
        if (isEmpty()) return false;

        front = (front + 1) % size;
        count--;
        return true;
    }

    // Deletes an item from the rear
    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear = (rear - 1 + size) % size;
        count--;
        return true;
    }

    // Get front item
    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    // Get last item
    public int getRear() {
        if (isEmpty()) return -1;
        return arr[(rear - 1 + size) % size];
    }

    // Checks if empty
    public boolean isEmpty() {
        return count == 0;
    }

    // Checks if full
    public boolean isFull() {
        return count == size;
    }
}
