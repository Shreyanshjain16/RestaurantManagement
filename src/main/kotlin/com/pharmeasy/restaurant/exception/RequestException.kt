package com.pharmeasy.restaurant.exception

class RequestException (override val message : String): RuntimeException(message,null,false,false)
//override