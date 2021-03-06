
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Node type for linked list
 * @author Upendra Reddy Lingareddygari
 *
 */
class LinkedListNode {
	
    private int value;
    private LinkedListNode next;
   
    /**
     * get value for the method
     * @return
     */
    public int getValue() {
        return value;
    }
   
    /**
     * setter for the value
     * @param input integer
     */
    public void setValue(int input) {
        value = input;
    }
   
    /**
     * method for the getting the next node
     * @return
     */
    public LinkedListNode getNext() {
        return next;
    }
   
    /**
     * Setter method for the next node
     * @param input LinkedListNode
     */
    public void setNext(LinkedListNode input) {
        next = input;
    }
   
    /**
     * default constructor
     */
    public LinkedListNode() {
    }
   
    /**
     * parameterized constructor
     * @param input integer
     */
    public LinkedListNode(int input) {
        this.setValue(input);
        this.setNext(null);
    }
}

/**
 * class for linkedlist implementation
 * @author Upendra Reddy Lingareddygari, Veera Venkata Ravi Teja Arrabolu
 *
 */
class LinkedList {
   
    private int length;
    private boolean isNegative = false;
    private LinkedListNode head;
    
    /**
     * Check if the given linkedlist is negative
     * @return boolean
     */
    public boolean isNegative() {
		return isNegative;
	}

    /**
     * set the sign of given linked list
     * @param isNegative
     */
	public void setNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}
   
    /**
     * length of the linked list
     * @return size
     */
    public int getLength() {
        return length;
    }
   
    /**
     * getter for the head of linked list
     * @return LinkedListNode
     */
    public LinkedListNode getHead() {
        return head;
    }
   
    /**
     * getter for the size of linkedlist
     * @return size of the list
     */
    public int getSize() {
        LinkedListNode current = head;
        int count = 0;
        while(current != null) {
            current = current.getNext();
        }
        return ++count;
    }
   
    /**
     * printall the elements in linkedlist
     */
    public void printAll() {
        LinkedListNode current = head;
        if(current != null) {
            while(current != null) {
                System.out.println(current.getValue());
                current = current.getNext();
            }
        } else {
            System.out.println("List is empty");
        }
    }
   
    /**
     * add an integer value to linkedlist
     * @param input element to add
     */
    public void add(int input) {
        if(head == null) {
            head = new LinkedListNode(input);
        } else {
            LinkedListNode current = head;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            LinkedListNode temp = new LinkedListNode(input);
            current.setNext(temp);
        }
        length++;
    }
   
    /**
     * add to the start of the linkedlist
     * @param input element to add
     */
    public void addToStart(int input) {
        if(head == null) {
            head = new LinkedListNode(input);
        } else {
            LinkedListNode temp = new LinkedListNode(input);
            temp.setNext(head);
            head = temp;
        }
        length++;       
    }
   
    /**
     * add an element to the linkedlist at the given index
     * @param input element to add
     * @param index index to be added
     */
    public void add(int input, int index) {
        LinkedListNode current = head;
        if(index > 0 && index <= length && head != null) {
            LinkedListNode temp = new LinkedListNode(input);
            if(index == 1) {               
                temp.setNext(head);
                head = temp;
            } else {
                int count = 0;
                while(current.getNext() != null && count < index - 2) {
                    count++;
                    current = current.getNext();
                }
                //System.out.println(count);
                temp.setNext(current.getNext());
                current.setNext(temp);
            }
            length++;
        } else {
            System.out.println("index out of bounds");
        }
    }
   
    /**
     * delete an elemet in the linkedlist at the given index
     * @param index index of the element to be deleted
     * @return value that has been removed from the linkedlist
     */
    public int delete(int index) {
        int result = -1;
        if(index > 0 && index <= length && head != null) {
            if(index == 1) {
                if(head.getNext() == null) {
                    head = null;
                } else {
                    result = head.getValue();
                    head.setValue(head.getNext().getValue());
                    head.setNext(head.getNext().getNext());
                }
            } else {
                LinkedListNode current = head;
                int count = 0;
                while(current.getNext() != null && count < index - 1) {
                    current = current.getNext();
                }
                if(current.getNext() == null) {
                    current.setNext(current.getNext());
                } else {
                    current.setNext(current.getNext().getNext());
                }
            }
            length--;
        } else {
            System.out.println("index out of bounds");
        }
        return result;
    }
   
    /**
     * delete an element in the linkedlist
     */
    public void delete() {
        head = null;
        length = 0;
    }
   
    /**
     * Reverse a block of k nodes from the linkedlist
     * @param x Node to start reversing at
     * @param k index from the start of the linkedlist
     * @return node of the linkedlist node of the reversed list
     */
    public LinkedListNode reverseBlockOfKNodes(LinkedListNode x, int k) {
        if(k == 0 || k == 1) {
            return x;
        } else {
            if(x == null) {
                return null;
            } else {
                LinkedListNode kth = getKthNode(x, k);
                if(kth == null) {
                    return x;
                } else {
                    LinkedListNode temp = kth.getNext();
                    kth.setNext(null);
                    LinkedListNode head = reverse(x);
                    x.setNext(reverseBlockOfKNodes(temp, k));
                    return head;
                }
            }
        }
    }
   
    /**
     * Reverse a given linkedlist
     * @param input node of a linkedlist
     * @return linkedlistnode of the linkedlist
     */
    public LinkedListNode reverse(LinkedListNode input) {
    	LinkedListNode x = input;
        if(x == null) {
            return x;
        } else {
            LinkedListNode temp = null;
            LinkedListNode next = null;
            while(x != null) {
                next = x.getNext();
                x.setNext(temp);
                temp = x;
                x = next;
            }
            return temp;
        }
    }
   
    /**
     * getter for getting the kth node of the linked list
     * @param x node in the linkedlist
     * @param k index of the node to be looked for
     * @return linked list node of the kth index
     */
    private LinkedListNode getKthNode(LinkedListNode x, int k) {
        if(x == null) {
            return null;
        }
        if(k == 0 || k == 1) {
            return x;
        } else {           
            int count = 1;
            while(x != null && count < k) {
                x = x.getNext();
                count++;
            }
            return x;
        }
    }

    /**
     * getting the node at given index of linkedlist
     * @param counter index of the node to be looked for
     * @return node of the linkedlist at the given linked list
     */
	public LinkedListNode getNodeAtIndex(int counter) {
		LinkedListNode temp = head;
		int i = 0;
		while(temp != null && i<counter) {
			temp = temp.getNext();
			i++;
		}
		return temp;
	}
}

/**
 * Main class for the project 4
 * @author Upendra Reddy Lingareddygari, Veera Venkata Ravi Teja Arrabolu
 *
 */
class uxr130130_P5 {
	
	/**
	 * Entry point for the given program
	 * @param args arguments to the program
	 */
    public static void main(String[] args) {
    	
    	String command = null;
    	ArrayList<String> commandList = new ArrayList<String>();
    	commandList.add(null);
    	Scanner input = new Scanner(System.in);
    	while(input.hasNext()) {
    		//lineNum = input.nextInt();
    		command = input.nextLine();
    		command = command.substring(command.indexOf(" ") + 1);
    		commandList.add(command);
    	}    	

    	HashMap<String, LinkedList> hm = new HashMap<String, LinkedList>();
    	String[] temp;
    	for(int i = 1; i < commandList.size(); i++){
    		command = commandList.get(i);
    		if(command.contains("=-")) {
    			temp = command.split("=-");
    			hm.put(temp[0], stringToNumber("-" + temp[1]));
    		} else if (command.contains("=")) {
				// addition
				if (command.contains("+")) {
					temp = command.split("=");
					hm.put(temp[0], add(hm.get(temp[1].split("\\+")[0]), hm.get(temp[1].split("\\+")[1])));
				}
				//subtraction
				else if(command.contains("-")){
					temp = command.split("=");
					hm.put(temp[0], subtract(hm.get(temp[1].split("\\-")[0]), hm.get(temp[1].split("\\-")[1])));
				}
				//multiplication
				else if(command.contains("*")){
					temp = command.split("=");
					hm.put(temp[0], multiply(hm.get(temp[1].split("\\*")[0]), hm.get(temp[1].split("\\*")[1])));
				}
				//power
				else if(command.contains("^")){
					temp = command.split("=");
					hm.put(temp[0], power(hm.get(temp[1].split("\\^")[0]), hm.get(temp[1].split("\\^")[1])));
				} else if(command.contains("/")) {
					temp = command.split("=");
					hm.put(temp[0], divide(hm.get(temp[1].split("/")[0]), hm.get(temp[1].split("/")[1]), "divide"));
				} else if(command.contains("%")) {
					temp = command.split("=");
					hm.put(temp[0], modulous(hm.get(temp[1].split("%")[0]), hm.get(temp[1].split("%")[1])));
				} else if(command.contains(")")) {
					temp = command.split("=");
					hm.put(temp[0], maxPower(hm.get(temp[1].substring(0, temp[1].indexOf(")")))));
				} else if(command.contains("~")) {
					temp = command.split("=");
					//hm.put(temp[0], squareRoot(hm.get(temp[1].substring(0, temp[1].indexOf("~")))));
				}
				//Initialization of variable
				else{
					if(hm.get(command.split("=")[0])!= null){
						hm.put(command.split("=")[0],new LinkedList());
					}
					hm.put(command.split("=")[0], stringToNumber(command.split("=")[1]));
				}
			} else if(command.contains("?")){
				temp = command.split("\\?");
				if(!checkIfZero(hm.get(temp[0]))){
					i = (Integer.parseInt(temp[1])-1);
				}
			} else {
					if(hm.get(command) != null){
						System.out.println(numberToString(hm.get(command)));
					}
			}
       	}
    	
    	input.close();
    	        
    } 
    
/*    private static LinkedList squareRoot(LinkedList input) {
		if(input.getLength() % 2 == 0) {
			
		} else {
			LinkedListNode current = input.getHead();
			
		}
    }
*/
    /**
     * find the power for the given number in 15 seconds
     * @param input
     * @return linkedlist of final value
     */
	private static LinkedList maxPower(LinkedList input) {
    	LinkedList result = input;
    	long timeAfter15Secs = System.currentTimeMillis() + 15000;
    	System.out.print(timeAfter15Secs);
		while(System.currentTimeMillis() < timeAfter15Secs) {
			result = multiply(result, result);
			System.out.println(System.currentTimeMillis());
		}
		return result;
	}

	/**
     * Find the modulus for the given digits
     * @param linkedList first linkedlist
     * @param linkedList second linked list
     * @return linkedlist of given number
     */
    private static LinkedList modulous(LinkedList first, LinkedList second) {
    	int compare = getMax(first, second);
    	LinkedList result = new LinkedList();
    	if(compare == 0) {
    		result.add(0);
    		return result;
    	} else if(compare < 0) {
    		result.setNegative(first.isNegative());
    		return first;
    	}
    	
    	first = divide(first, second, "modulus");
    	first.setNegative(first.isNegative());
    	return first;
    }

	/**
     * Divisoin of given linked lists 
     * @param first linkedlist one
     * @param second linkedlist two
     * @return Linkedlist after dividing the input
     */
    private static LinkedList divide(LinkedList first, LinkedList second, String type) {
    	int compare = getMax(first, second);
    	LinkedList result = new LinkedList();
    	if(compare == 0) {
    		result.setNegative(first.isNegative() & second.isNegative());
        	result.add(1);
        	return result;
    	} else if(compare == -1) {
    		result.add(0);
    		return result;
    	}
    	
    	LinkedList listWithOne = new LinkedList();
    	listWithOne.add(1);
    	result.add(0);
    	
    	do{
    		first = subtract(first, second);
    		result = add(result, listWithOne);
    	} while(getMax(first, second) >= 0); //condition
    	
    	return type.equals("divide") ? result : first;
    }

	/**
     * Check if the given list contains just zero.
     * @param input LinkedList
     * @return boolean value representing if the zero exists in linkedlist
     */
    private static boolean checkIfZero(LinkedList input) {
    	LinkedListNode current = input.getHead();
    	while(current != null) {
    		if(current.getValue() != 0) {
    			return false;
    		}
    		current = current.getNext();
    	}
    	return true;
    }
   
    /**
     * Given a string returns a linkedlist
     * @param input integer in string
     * @return LinkedList
     */
    private static LinkedList stringToNumber(String input) {
       LinkedList result = new LinkedList();
       for(char c : input.toCharArray()) {
    	   if(c == '-') {
    		   result.setNegative(true);
    	   } else {
    		   result.addToStart(Integer.parseInt(String.valueOf(c)));
    	   }
       }
       return result.getLength() == 0 ? null : result;
    }
    
    /**
     * method to multiply given integers
     * @param first linkedList of numbers
     * @param second linkedList of numbers
     * @return LinkedList representing the resultent output
     */
    private static LinkedList multiply(LinkedList first, LinkedList second) {
    	if(first == null || second == null) {
    		return null;
    	}
    	
    	LinkedListNode firstNode;
    	LinkedListNode secondNode = second.getHead();
    	LinkedList result = new LinkedList();
    	for(int i = 0; i < first.getLength(); i++) {
    		result.add(0);
    	}
    	LinkedListNode resultNode;
    	int carry = 0;
    	int value = 0;
    	int counter = 0;
    	while(secondNode != null) {
    		firstNode = first.getHead();
    		resultNode = result.getNodeAtIndex(counter);
    		while(firstNode != null) {
    			if(resultNode != null) {
    				value = secondNode.getValue() * firstNode.getValue() + carry + resultNode.getValue();
       			} else {
    				value = secondNode.getValue() * firstNode.getValue() + carry;
    			}
    			if(value >= 10) {
    				carry = value/10;
    				value = value%10;
    			} else {
    				carry = 0;
    			}
    			
    			if(resultNode != null) {
    				resultNode.setValue(value);
    			} else {
    				result.add(value);
    			}    			
    			if(resultNode != null) {
    				resultNode = resultNode.getNext();
    			}
    			firstNode = firstNode.getNext();
    		}
    		if(carry != 0) {
	    		result.add(carry);
				carry = 0;
    		}
    		secondNode = secondNode.getNext();
    		counter++;
    	}
    	result.setNegative(first.isNegative() & second.isNegative());
    	return result;
    }
    
    /**
     * Given a linkedlist outputs a string representation.
     * @param input linkedlist of the given integer representations
     * @return String format of the linkedlist
     */
    private static String numberToString(LinkedList input) {
    	if(input.getLength() != 0) {
	    	StringBuilder builtString = new StringBuilder();
	    	
	    	LinkedList temp = new LinkedList();
	    	LinkedListNode x = input.getHead();
	    	while(x != null) {
	    		temp.add(x.getValue());
	    		x = x.getNext();
	    	}
	    	
	    	LinkedListNode current = temp.reverse(temp.getHead());
	    	
	    	while(current != null) {
	    		builtString.append(current.getValue());
	    		current = current.getNext();
	    	}
	    	
	    	int startOfNonZeroNumber = 0;
	    	for(int i = 0; i < builtString.length(); i++) {
	    		if(builtString.charAt(i) != 0) {
	    			startOfNonZeroNumber = i;
	    			break;
	    		}
	    	}
	    	return input.isNegative() ? "-" + builtString.toString().substring(startOfNonZeroNumber) : builtString.toString().substring(startOfNonZeroNumber);
    	} else 	{
    		return "0";
    	}
    	
    }
    
    /**
     * Addition of given linkedlist representations
     * @param first LinkedList
     * @param second LinkedList
     * @return summation of the given linkedlists
     */
    private static LinkedList add(LinkedList first, LinkedList second) {
    	
    	if(first == null) {
    		return second;
    	}
    	
    	if(second == null) {
    		return first;
    	}
    	
    	if((first.isNegative() && !second.isNegative()) || (!first.isNegative() && second.isNegative())) {
    		return subtract(first, second);
    	}
    	
    	
    	LinkedList result = new LinkedList();
    	
    	if(first.isNegative() && second.isNegative()) {
    		result.setNegative(true);
    	}
    	
    	LinkedList firstTemp = new LinkedList();
    	LinkedListNode firstTempNode = first.getHead();
    	while(firstTempNode != null) {
    		firstTemp.add(firstTempNode.getValue());
    		firstTempNode = firstTempNode.getNext();
    	}
    	
    	LinkedList secondTemp = new LinkedList();
    	LinkedListNode secondTempNode = second.getHead();
    	while(secondTempNode != null) {
    		secondTemp.add(secondTempNode.getValue());
    		secondTempNode = secondTempNode.getNext();
    	}
    	
    	
    	LinkedListNode firstNode = firstTemp.getHead();
    	LinkedListNode secondNode = secondTemp.getHead();
    	
    	int sum = 0;
    	int carry = 0;
    	
    	while(firstNode != null && secondNode != null) {
    		sum = firstNode.getValue() + secondNode.getValue() + carry;
    		if(sum >= 10) {
    			carry = 1;
    		} else {
    			carry = 0;
    		}
    		result.add(sum%10);
    		firstNode = firstNode.getNext();
    		secondNode = secondNode.getNext();
    	}
    	
    	while(firstNode != null) {
    		sum = firstNode.getValue() + carry;
    		if(sum >= 10) {
    			carry = 1;
    		} else {
    			carry = 0;
    		}
    		result.add(sum%10);
    		firstNode = firstNode.getNext();
    	}
    	
    	while(secondNode != null) {
    		sum = secondNode.getValue() + carry;
    		if(sum >= 10) {
    			carry = 1;
    		} else {
    			carry = 0;
    		}
    		result.add(sum%10);
    		secondNode = secondNode.getNext();
    	}
    	
    	if(carry == 1) { 
    		result.add(1); 
    	}
    	
    	return result;
    }
    
    /**
     * Substraction of given linkedList
     * @param first linkedlist
     * @param second linkedList
     * @return result in linkedlist for the given linkedlist
     */
    private static LinkedList subtract(LinkedList first, LinkedList second) {
    	if(first == null && second == null) {
    		LinkedList temp = new LinkedList();
    		temp.add(0);
    		return temp; 
    	}
    	
    	if(first == null) {
    		if(!second.isNegative()) {
    			second.setNegative(true);
    		}
    		return second;
    	}
    	
    	if(second == null) {
    		return first;
    	}
    	
    	LinkedList result = new LinkedList();
    	int compare = getMax(first, second);
    	
    	if(compare == 0) {
    		if((first.isNegative() && second.isNegative()) || (!first.isNegative() && !second.isNegative())) {
    			LinkedList temp = new LinkedList();
        		temp.add(0);
        		return temp;
    		} else {
    			if(first.isNegative()) {
    				first.setNegative(false);
    				result = add(first, second);
    				result.setNegative(true);
    				
    			} else {
    				second.setNegative(false);
    				result = add(first, second);
    				result.setNegative(false);
    			}
    			return result;
    		}    		
    	} else if(compare == 1) {
    		if(!first.isNegative() && !second.isNegative()) {
    			
    		} else if(!first.isNegative() && second.isNegative()) {
    			second.setNegative(false);
    			return add(first, second);
    		} else if(first.isNegative() && !second.isNegative()) {
    			first.setNegative(false);
    			result = add(first, second);
    			result.setNegative(true);
    			return result;
    		} else {
    			result.setNegative(true);    			
    		}
    	} else {
    		if(!first.isNegative() && !second.isNegative()) {
    			LinkedList temp = first;
    			first = second;
    			second = temp;
    			result.setNegative(true);
    		} else if(!first.isNegative() && second.isNegative()) {
    			second.setNegative(false);
    			return add(first, second);
    		} else if(first.isNegative() && !second.isNegative()) {
    			first.setNegative(false);
    			result = add(first, second);
    			result.setNegative(true);
    			return result;
    		} else {
    			second.setNegative(false);
    			first.setNegative(false);
    			LinkedList temp = first;
    			first = second;
    			second = temp;    			
    			result.setNegative(false);    			
    		}
    	}
    	
    	LinkedList firstTemp = new LinkedList();
    	LinkedListNode firstTempNode = first.getHead();
    	while(firstTempNode != null) {
    		firstTemp.add(firstTempNode.getValue());
    		firstTempNode = firstTempNode.getNext();
    	}
    	
    	LinkedList secondTemp = new LinkedList();
    	LinkedListNode secondTempNode = second.getHead();
    	while(secondTempNode != null) {
    		secondTemp.add(secondTempNode.getValue());
    		secondTempNode = secondTempNode.getNext();
    	}
    	
    	firstTemp = removePrecedingZeros(firstTemp);
    	secondTemp = removePrecedingZeros(secondTemp);
    	
    	LinkedListNode firstNode = firstTemp.getHead();
    	LinkedListNode secondNode = secondTemp.getHead();
    	int borrow = 0;
    	int difference = 0;
    	boolean negativeFlag = false;
    	
    	while(firstNode != null && secondNode != null) {
    		if(firstNode.getValue() + borrow >= secondNode.getValue()) {
    			difference = firstNode.getValue() + borrow - secondNode.getValue();
    			borrow = 0;
    		} else {
    			if(firstNode.getNext() != null) {
    				difference = firstNode.getValue() + borrow + 10 - secondNode.getValue();
    				borrow = -1;
    			} else {
    				negativeFlag = true;
    				break;
    			}
    		}
    		result.add(difference);
    		firstNode = firstNode.getNext();
    		secondNode = secondNode.getNext();
    	}
    	
    	while(firstNode != null) {
    		if(firstNode.getValue() + borrow < 0) {
    			result.add(firstNode.getValue() + borrow + 10);
    			borrow = -1;
    		} else {
    			result.add(firstNode.getValue() + borrow);
    			borrow = 0;
    		}
    		firstNode = firstNode.getNext();
    	}
    	
    	if(borrow == -1 || negativeFlag || secondNode != null) {
    		result = new LinkedList();
    		result.add(0);
    		return result;
    	}
    	
    	return removePrecedingZeros(result);
    }

    /**
     * exponential of given integers
     * @param first linkedlist
     * @param second linkedlist
     * @return result in linkedlist for the given linkedlists exponentials
     */
    private static LinkedList power(LinkedList first, LinkedList second) {
    	if(first.getLength() == 0 || second.getLength() == 0) {
    		return null;
    	}
    	
    	LinkedList result = new LinkedList();
    	
    	if(second.getLength() == 1 && second.getHead().getValue() == 0) {
    		result.add(1);
    		return result;   		
    	}
    	
    	if(second.isNegative()) {
    		if(first.getHead().getValue() == 1) {
    			if(first.isNegative()) {
    				//LinkedList modulo = modulo(second, new LinkedList().add(2));
    				//if(modulo.getHead().getValue() != 0) {
    					//result.setNegative(true);
    				//}    				
    			} 
    			result.add(1);
				return result;
    		} else {
    			result.add(0);
    			return result;
    		}
    	}

    	LinkedList listWithOne = new LinkedList();
    	listWithOne.add(1);
    	result = first;
    	
    	while(!numberToString(second).equals("1")) {
    		result = multiply(result, first);
    		second = subtract(second, listWithOne);
    	}
    	
    	return result;
    }
    
    /**
     * Given a linked list for returns the string format removing leading zeros
     * @param input LinkedList
     * @return string format after removing zeros
     */
    private static LinkedList removePrecedingZeros(LinkedList input) {
    	StringBuilder builtString = new StringBuilder();
    	LinkedListNode current = input.reverse(input.getHead());
    	
    	while(current != null) {
    		builtString.append(current.getValue());
    		current = current.getNext();
    	}
    	
    	int startOfNonZeroNumber = -1;
    	
    	for(int i = 0; i < builtString.length(); i++) {
    		if(builtString.charAt(i) != '0') {
    			startOfNonZeroNumber = i;
    			break;
    		}
    	}
    	
    	return startOfNonZeroNumber == -1 ? new LinkedList() : stringToNumber((input.isNegative() ? "-" : "") + builtString.toString().substring(startOfNonZeroNumber));

    }
    
    /**
     * get the maximum linkedList of given numbers
     * @param first LinkedList
     * @param second LinkedList
     * @return max of given LinkedList
     */
    private static int getMax(LinkedList first, LinkedList second) {
    	
    	LinkedList firstTemp = new LinkedList();
    	LinkedListNode firstTempNode = first.getHead();
    	while(firstTempNode != null) {
    		firstTemp.add(firstTempNode.getValue());
    		firstTempNode = firstTempNode.getNext();
    	}
    	
    	LinkedList secondTemp = new LinkedList();
    	LinkedListNode secondTempNode = second.getHead();
    	while(secondTempNode != null) {
    		secondTemp.add(secondTempNode.getValue());
    		secondTempNode = secondTempNode.getNext();
    	}
    	
    	firstTemp = removePrecedingZeros(firstTemp);
    	secondTemp = removePrecedingZeros(secondTemp);
    	
    	LinkedListNode firstNode = firstTemp.getHead();
    	LinkedListNode secondNode = secondTemp.getHead();

    	
    	if(first.getLength() == second.getLength()) {
    		LinkedListNode currentFirstNode = first.reverse(firstNode);
    		LinkedListNode currentSecondNode = second.reverse(secondNode);
    		
    		while(currentFirstNode != null && currentSecondNode != null) {
    			if(currentFirstNode.getValue() > currentSecondNode.getValue()) {
    				return 1;
    			} else if(currentFirstNode.getValue() < currentSecondNode.getValue()) {
    				return -1;
    			} else {
    				currentFirstNode = currentFirstNode.getNext();
    				currentSecondNode = currentSecondNode.getNext();
    			}
    		}
    		return 0;
    	} else {
    		return first.getLength() > second.getLength() ? 1 : -1;
    	}
    }

       
}
