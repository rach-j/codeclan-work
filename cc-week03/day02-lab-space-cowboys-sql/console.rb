require('pry-byebug')
require_relative('models/bounty')

space_cowboy1 = Bounty.new({
  'name' => 'Clint Eastwood',
  'species' => 'human',
  'bounty_value' => 1000,
  'danger_level' => 'low'})

  space_cowboy2 = Bounty.new({
    'name' => 'Yul Brynner',
    'species' => 'android',
    'bounty_value' => 5000,
    'danger_level' => 'high'})

binding.pry

NIL
