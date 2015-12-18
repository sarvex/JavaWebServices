## Ten curl commands to test that the predictions2 service is CRUD compliant.
use strict;

sub hit_any_key {
    print "\n# Hit any key to continue...";
    my $ret = <>;
}

my @curlCommands = (
    'curl --request GET http://localhost:8080/predictions2',
    'curl --request GET http://localhost:8080/predictions2?id=31',
    'curl --header "Accept: application/json" localhost:8080/predictions2/',
    'curl --header "Accept: application/json" localhost:8080/predictions2?id=11',
    'curl --request POST --data "who=TSEliot&what=This is the way the world ends" localhost:8080/predictions2/',
    'curl localhost:8080/predictions2/',
    'curl --request PUT --data "id=33#what=This is an update" localhost:8080/predictions2/',
    'curl localhost:8080/predictions2/',
    'curl --request DELETE localhost:8080/predictions2?id=33',
    'curl localhost:8080/predictions2/'
    );

foreach my $cmd(@curlCommands) {
    print `clear`;      ## May not work on Windows
    print "\n\n### $cmd\n";
    hit_any_key();
    system($cmd);
    hit_any_key();
}
