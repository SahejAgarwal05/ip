# Sahej User Guide
<img width="514" alt="image" src="https://github.com/user-attachments/assets/1c9120ff-6dd2-4460-8f78-3895bbbd53aa" />

Sahej is a specilized calender manager bot on the Command Line Interface designed to help the user store and manage several events, deadlines and todos through a list. Sahej automatically retreives and stores your list localy so you can easily use it across mutliple runs.

## Adding deadlines

Deadlines are tasks that need to be completed by a certain date. Deadlines can be added to your list thorugh: 
```deadline <name of the deadline> /by <date in YYYY-MM-DD>```

Examples: 
deadline return books /by 2025-02-23
deadline pay bills /by 2025-03-23

Expected output 
```
____________________________________________________________
	Added <name of the deadline>  (by:<date in MMM DD YYYY)
____________________________________________________________
```

## Adding ToDos
ToDos are tasks that that do not have an particular deadline or time. ToDos can be added to your list thorugh: 
```todo <name of the todo>```

Examples:
todo play football
todo watch news

Expected output 
```
____________________________________________________________
	Added : [ ][T] <name of the todo>
____________________________________________________________
```

## Adding Events
Events are like real life events with a start and end time. Events can be added to your list thorugh: 
```event <name of the event> /from <date in any format> /to <date in any format>```

Examples
event math class /from monday 2pm /to monday 3pm

Expected output 
```
____________________________________________________________
	Added : [ ][E] <name of the event> (from: <from date> to: <to date>)
____________________________________________________________
```

## Listing
You can view all the todos, deadlines and events in your list using 
```
list
```
Expected output: your complete list


## Marking 
Anything in your list can be marked as complete using through 
``` mark <index of item to be marked complete>```

Examples 
mark 3

Exapcted Output:
```
____________________________________________________________
	Marked: <index of item to be marked complete>`
____________________________________________________________
```

## Unmarking 
Anything in your list can be marked as incomplete using through 
``` unmark <index of item marked complete>```

Examples 
unmark 3

Exapcted Output:
```
____________________________________________________________
	Unarked: <index of item marked incomplete>`
____________________________________________________________
```

## Deleteing 
Anything in your list can be deleted through 
``` delete <index of item to be deleted>```

Examples 
delete 3

Exapcted Output:
```
____________________________________________________________
  Deleted	: <index of item deleted>`
____________________________________________________________
```

## Finding
You can search the items in your list using
```find <keyword(s)>```
the keywords are case insesitive

Examples 
find book
find Book

Exapcted Output:
List of tiems found


## Exiting
You can save and exit using:
```bye```


