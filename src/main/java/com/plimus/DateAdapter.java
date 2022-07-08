/**
 * This date formatter is used by the Jaxb framework to translate from
 * {@link String} to {@link Date} and vice-versa. It is defined in the
 * ws-bindings.xjb file as a global binding.
 * 
 * @author Uri Bar
 */
package com.plimus;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter
    extends XmlAdapter<String, Date>
{

    public Date unmarshal(String value) {
      Date parsedDate = null;
      try {
        parsedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(value);
      }
      catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
      return parsedDate;
    }

    public String marshal(Date value) {
      String result = null;
      if (value != null) {

        result = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(value);
      }

      return result;
    }

}
