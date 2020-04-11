package CampusGame;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XML_240
{

    XMLEncoder xe;
    XMLDecoder de;

    public XML_240()
    {

    }
//==========================================================================

    public void openReaderXML(String filename)
    {
        try
        {
            de = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================

    public void openWriterXML(String filename)
    {
        try
        {
            xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================

    public void writeObject(Object o)
    {
        try
        {
            xe.writeObject(o);
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================

    public Object ReadObject()
    {
        Object o = new Object();
        try
        {
            o = de.readObject();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
        return o;
    }
//==========================================================================

    public void closeReaderXML()
    {
        try
        {
            de.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
//==========================================================================

    public void closeWriterXML()
    {
        try
        {
            xe.close();
        } catch (Exception xx)
        {
            xx.printStackTrace();
        }
    }
}