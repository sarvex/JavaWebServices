#!/usr/bin/perl -w

use SOAP::Lite +trace => 'debug';                                         ## a Perl SOAP library
use strict;

my $soap = 
    SOAP::Lite->uri('http://rand/')->proxy('http://localhost:8888/rs/');  ## service endpoint
my $num = $soap->next1()->result();                                       ## response from the service
print "Response is: $num\n";                                              ## value returned
$num = $num + 100;           ## arithmetic operation to show $num is truly a numeric value

