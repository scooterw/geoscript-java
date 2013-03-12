base_path = File.join(File.expand_path(File.dirname(__FILE__)), 'target')
jar_path = File.join(base_path, 'dependency')

Dir.entries(jar_path).sort.each do |entry|
  $CLASSPATH << File.join(jar_path, entry) if entry =~ /.jar$/
end

$CLASSPATH << File.join(base_path, 'geoscript-0.0.1.jar')
