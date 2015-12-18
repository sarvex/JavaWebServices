## Ten curl commands to exhibit the functionality of the JAX-RS predictions3 service.
use strict;

sub hit_any_key {
    print "\n# Hit any key to continue...";
    my $ret = <>;
}

my @curlCommands = (
    'curl --request GET http://localhost:8080/predictions3/resourcesP/xml/12',
    'curl --request GET http://localhost:8080/predictions3/resourcesP/xml/foo',
    'curl --request GET http://localhost:8080/predictions3/resourcesP/json',
    'curl --request GET http://localhost:8080/predictions3/resourcesP/plain',
    'curl --request POST --data "who=TSEliot&what=This is the way the world ends"' .
          ' http://localhost:8080/predictions3/resourcesP/create',
    'curl localhost:8080/predictions3/resourcesP/plain',
    'curl --request DELETE localhost:8080/predictions3/resourcesP/delete/33',
    'curl localhost:8080/predictions3/resourcesP/plain'
    );

foreach my $cmd(@curlCommands) {
    print `clear`;      ## May not work on Windows
    print "\n\n### $cmd\n\n";
    hit_any_key();
    system($cmd);
    hit_any_key();
}
