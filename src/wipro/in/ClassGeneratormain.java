package wipro.in;



import cap.in.Linkedlist;
import io.calci.ConsoleInput;

public class ClassGeneratormain {
	
	public static void main(String []args)
	{
		
	Linkedlist <Object>objList=new Linkedlist<>();
	String classAccessSpecifier =null;
	
	try {
	System.out.println("Enter the name of the Package");
	String packageName=ConsoleInput.getString();
	System.out.println("Enter the name of the Class");
	String className=ConsoleInput.getString();
	System.out.println("Choose the accessSpecifierType for the class");
	System.out.println("1.Public Access Specifier");
	System.out.println("2.Default Access Specifier");
	int classAccessSpecChoice=ConsoleInput.getInt();
	switch(classAccessSpecChoice)
	{
		case 1:
			classAccessSpecifier="public";
			break;
		case 2:
			classAccessSpecifier="";//defaultType
			break;
		default:
			System.out.println("Invalid class access specifier");
			break;
			
	}
	while(true) {
	DisplayOptions.menuList();
	int menuType=ConsoleInput.getInt();
	switch(menuType)
	{
		case 1:
			Field fieldObj=new Field();
			System.out.println("Enter the Field Name :");
			fieldObj.fieldName=ConsoleInput.getString();
			System.out.println("Field AccessModifier Type");
					DisplayOptions.accessSpecifiers();
					System.out.println("Select one of the access specifiers for the field:");
					int fieldAccessSpecifierType=ConsoleInput.getInt();
					switch(fieldAccessSpecifierType)
					{
						case 1:
							fieldObj.fieldAccessSpecifier="private";
							break;
						case 2:
							fieldObj.fieldAccessSpecifier="";break;
						case 3:
							fieldObj.fieldAccessSpecifier="protected";break;
						case 4:
							fieldObj.fieldAccessSpecifier="public";break;
						default:
							System.out.println("Invalid fieldAccessSpecifier type ");break;
					}
					System.out.println("Field Data Type");
					DisplayOptions.returnTypes();
					System.out.println("Select one of the Field data types for the field:");
					int fieldDataTypeType=ConsoleInput.getInt();
					switch(fieldDataTypeType)
					{
						case 1:
							fieldObj.fieldType="int";break;
						case 2:
							fieldObj.fieldType="float";break;
						case 3:
							fieldObj.fieldType="String";break;
						case 4:
							System.out.print("User Defined Data Type Name :");
							fieldObj.fieldType=ConsoleInput.getString();
						default:
							System.out.println("Invalid Field Type");
					}
					objList.addNode(fieldObj);
					break;
			
			case 2:
				Method methodObj=new Method();
				System.out.println("Enter the Method Name :");
				methodObj.methodName=ConsoleInput.getString();
				System.out.println("1.Method AccessModifier Type");
				DisplayOptions.accessSpecifiers();
				System.out.println("Select one of the access specifiers for the Method:");
				int methodAccessSpecifierType=ConsoleInput.getInt();
				switch(methodAccessSpecifierType)
				{
					case 1:
						methodObj.methodAccessSpecifier="private";
						break;
					case 2:
						methodObj.methodAccessSpecifier="";break;
					case 3:
						methodObj.methodAccessSpecifier="protected";break;
					case 4:
						methodObj.methodAccessSpecifier="public";break;
					default:
						System.out.println("Invalid fieldAccessSpecifier type ");break;
				}
				DisplayOptions.returnTypes();
				System.out.println("2.Method return Type");
				System.out.println("Select one of the Method data types for the field:");
				int methodreturnTypeType=ConsoleInput.getInt();
				switch(methodreturnTypeType)
				{
					case 1:
						methodObj.methodReturnType="int";break;
					case 2:
						methodObj.methodReturnType="float";break;
					case 3:
						methodObj.methodReturnType="String";break;
					case 4:
						System.out.print("User Defined Data Type Name :");
						methodObj.methodReturnType=ConsoleInput.getString();
					default:
						System.out.println("Invalid Field Type");
				}
				objList.addNode(methodObj);
				break;
		case 3:
			System.out.print("package ");
			System.out.println(packageName);
			System.out.print(classAccessSpecifier+" class ");
			System.out.println(className);
			System.out.println("{");
			if(objList.getFirst() instanceof Field)
			{
				Field fieldObjNew= (Field)objList.getFirst();
				System.out.println("\t"+fieldObjNew.fieldAccessSpecifier+" "+fieldObjNew.fieldType+" "+fieldObjNew.fieldName+";");
				
			}
			else if(objList.getFirst() instanceof Method)
			{
				Method methodObjNew=(Method)objList.getFirst();
				System.out.println("\t"+methodObjNew.methodAccessSpecifier+" "+methodObjNew.methodReturnType+" "+methodObjNew.methodName);
				System.out.println("\t{");
				System.out.println("\t}");
				System.out.println("}");break;
			}
			while(true)
			{
				if(objList.getNext()instanceof Field)
				{
					objList.getPrevious();
					Field nextFieldObj=(Field)objList.getNext();
					System.out.println("\t+"+nextFieldObj.fieldAccessSpecifier+" "+nextFieldObj.fieldType+" "+nextFieldObj.fieldName+";");
					
				}
				objList.getPrevious();
				if(objList.getNext() instanceof Method) {
					objList.getPrevious();
					Method nextMethodObj=(Method)objList.getNext();
					System.out.println("\t"+nextMethodObj.methodAccessSpecifier+" "+nextMethodObj.methodReturnType+" "+nextMethodObj.methodName+"()");
					System.out.println("\t{");
					System.out.println("\t}");
					System.out.println("}");break;
				}
				if(objList.getNext()==null)
				{
					break;
				}
				objList.getPrevious();
			}
			System.out.println("}");
			break;
		default:
			System.out.println("Invalid Menu Type");
	}
	if(menuType==3) {
		break;
		}
	
	}

	
}
	catch(Exception e)
	{
		System.out.println("Invalid input type");
	}
	}
}
