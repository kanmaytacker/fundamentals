from collections import deque
def merge(process, arivalTime,burstTime):
      
    merged_list = [(process[i], arivalTime[i],burstTime[i]) for i in range(0, len(process))]
    return merged_list
def middle(n):  
    return n[1]

def sort(Arival_sort):  
    return sorted(Arival_sort, key = middle)


## now we need to insert into the queue for calculating the process FCFS working
def FCFS(sorted_list):
    res=[]
    total_time=[]
    queue=deque(sorted_list)
    print(queue)
    i=0
    sum=0
    while(i<len(queue)):
        ans=queue[i]
        print(ans)
        x,y,z=ans
        ## process id which excuted first
        res.append(x)
        sum=sum+z
        total_time.append(sum)

        i+=1
    
    print("this is the way the process excution:",res)
    print("this is the time each process excution",total_time)




## this is for arival time  same we need to check our burst time which is smaller excution first
## then other
def FCFS_tie_break(sorted_list):
    res=[]
    total_time=[]
    queue=deque()
    queue.append(sorted_list[0])
    for i in range(1,len(sorted_list)):
        h=queue.pop()
        a,b,c=h
        q,f,g=sorted_list[i]
        if(b==f):
            if(g<c):
                queue.append(sorted_list[i])
                queue.append(h)
        else:
            queue.append(h)
            queue.append(sorted_list[i])

    print(queue)
    i=0
    sum=0
    while(i<len(queue)):
        ans=queue[i]
        print(ans)
        x,y,z=ans
        ## process id which excuted first
        res.append(x)
        sum=sum+z
        total_time.append(sum)

        i+=1
    
    print("this is the way the process excution:",res)
    print("this is the time each process excution",total_time)
        
if __name__ =="__main__":
    #process id 
    process=['p1','p2','p3','p4','p5']
    # arival time 
    arivalTime=[2,1,0,4,2]
    #burst time of processes
    burstTime=[6,8,3,4,5]
    print(merge(process, arivalTime,burstTime))
    ## sort the tuple according to the arival time
    Arival_sort=merge(process, arivalTime,burstTime)
    ## print the sorted order of tuple
    print(sort(Arival_sort))
    ## sorted tuple  into the list
    sorted_list=sort(Arival_sort)
    print(FCFS(sorted_list))
    ## assigment work
    print("_________________________")
    print("Assigment-1")
    print("___________________________________________")
    ## if the look the output from below for tie-breaking inscheduling
    ## if two process have same arival time  then check lost burst time 
    ## from below p1 arival time is 2 and p5 arival time is also 2 but according to the assigment we need to p5 first then p1
    ## how we do that 
    print("if the look the output from above for tie-breaking inscheduling\n if two process have same arival time  then check lost burst time \n from below p1 arival time is 2 and p5 arival time is also 2 but according to the assigment we need to p5 first then p1\n how we do that ")
    print(FCFS_tie_break(sorted_list))