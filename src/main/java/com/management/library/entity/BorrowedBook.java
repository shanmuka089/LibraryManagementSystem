package com.management.library.entity;

import java.util.Date;

public class BorrowedBook
{
    private String learnerId;
    private String learnerName;
    private BookCopy bookCopy;
    private Date borrowedDate;
    private Date dueDate;
    private Date returnedDate;
    private BorrowStatus status;

    public String getLearnerId()
    {

        return learnerId;
    }

    public void setLearnerId(String learnerId)
    {

        this.learnerId = learnerId;
    }

    public String getLearnerName()
    {

        return learnerName;
    }

    public void setLearnerName(String learnerName)
    {

        this.learnerName = learnerName;
    }

    public BookCopy getBookCopy()
    {

        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy)
    {

        this.bookCopy = bookCopy;
    }

    public Date getBorrowedDate()
    {

        return borrowedDate;
    }

    public void setBorrowedDate(Date borrowedDate)
    {

        this.borrowedDate = borrowedDate;
    }

    public Date getDueDate()
    {

        return dueDate;
    }

    public void setDueDate(Date dueDate)
    {

        this.dueDate = dueDate;
    }

    public Date getReturnedDate()
    {

        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate)
    {

        this.returnedDate = returnedDate;
    }

    public BorrowStatus getStatus()
    {

        return status;
    }

    public void setStatus(BorrowStatus status)
    {

        this.status = status;
    }

    @Override
    public String toString()
    {

        return "BorrowedBook{" +
                "learnerId='" + learnerId + '\'' +
                ", learnerName='" + learnerName + '\'' +
                ", bookCopy=" + bookCopy +
                ", borrowedDate=" + borrowedDate +
                ", dueDate=" + dueDate +
                ", returnedDate=" + returnedDate +
                ", status=" + status +
                '}';
    }

}
