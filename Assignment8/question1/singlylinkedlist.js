/**
 * Method to initialise head with null.
 */
function LinkedList(){
    this.head = null;
}

/**
 * Method to add a element to the linked list.
 * @param {value to insert} val 
 */
LinkedList.prototype.addElement = function(val){

    var node = {
        value: val,
        next: null
    }

    if(!this.head){
        this.head = node;
    }
    else{
        var current = this.head;

        while(current.next){
            current = current.next;
        }
        current.next = node;
    }

}

/**
 * Method to remove a element from the linked list.
 * @param {value to be removed} val 
 */
LinkedList.prototype.removeElement = function(val){

    if(!this.head){
        console.log("Linked List is empty!! Element cannot be removed!!..");
    }

    var prev = null;
    var current = this.head;

    while(current != null){

        if(current.value == val){
           
            if(prev == null){
                this.head = current.next;
                console.log("Element removed!!..");
                return;
            }else{
                prev.next = current.next;
                console.log("Element removed!!..");
                return;
            }
        }
        prev = current;
        current = current.next;

    }
    console.log("Element not found!!.. Cannot be removed!!..");
    return;
}

/**
 * Method to search element in a linked list.
 * @param {value to be searched} val 
 */
LinkedList.prototype.searchElement = function(val){

    if(!this.head){
        console.log("Linked list is empty!!..");
        return;
    }

    var current = this.head;

    while(current.next){

        if(current.value == val){
            console.log("Value is found");
            return;
        }

        current = current.next;
    }

    console.log("value does not exist");
    return;
}

/**
 * Method to remove a element in a linked list.
 * @param {value to be removed} val 
 */
LinkedList.prototype.displayElements = function(){

    var current = this.head;

    while(current){
        console.log(current.value);
        current = current.next;
    }

}

function main(){

    var linkedlist = new LinkedList();

    linkedlist.addElement(1);
    linkedlist.addElement(2);
    linkedlist.addElement(3);
    linkedlist.addElement(4);
    linkedlist.addElement(5);

    linkedlist.displayElements();

    linkedlist.removeElement(3);

    linkedlist.searchElement(1);

    linkedlist.displayElements();
}

main();